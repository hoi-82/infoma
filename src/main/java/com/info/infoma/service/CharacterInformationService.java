package com.info.infoma.service;

import com.info.infoma.domain.dto.character.*;
import com.info.infoma.domain.dto.response.CharacterBasicTotalInformation;
import com.info.infoma.domain.dto.response.CharacterEquipmentTotalInformation;
import com.info.infoma.domain.dto.response.CharacterSkillTotalInformation;
import com.info.infoma.domain.dto.response.CharacterStatTotalInformation;
import com.info.infoma.domain.entity.*;
import com.info.infoma.domain.entity.common.CharacterCommonCache;
import com.info.infoma.domain.enums.SkillType;
import com.info.infoma.domain.vo.DojangRecord;
import com.info.infoma.domain.vo.Propensity;
import com.info.infoma.openfeign.CharacterInformationClient;
import com.info.infoma.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * 캐릭터 정보 조회 서비스
 *
 * 전날 정보만을 불러오고 있으며, 캐릭터 명/OCID 수집
 * 2024-04-05 -> 실시간 데이터로 변경 작업
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CharacterInformationService {

    // Feign Client
    private final CharacterInformationClient characterInformationClient;

    // RDB Repository
    private final CharacterOcidRepository characterOcidRepository;

    // Cache Repository
    private final CharacterBasicCacheRepository characterBasicCacheRepository;
    private final CharacterEquipmentCacheRepository characterEquipmentCacheRepository;
    private final CharacterSkillCacheRepository characterSkillCacheRepository;
    private final CharacterStatCacheRepository characterStatCacheRepository;

    /**
     * 캐릭터 Ocid 조회
     */
    @Transactional
    private String getCharacterOcid(String characterName) throws Exception {
        // RDB에 Ocid 수집
        Optional<CharacterOcid> byCharName = characterOcidRepository.findByCharName(characterName);
        if(byCharName.isPresent()) return byCharName.orElseThrow().getCharacterOcid();
        else {
            String characterOcid = characterInformationClient.getUserOcid(characterName).ocid();
            CharacterOcid newOcid = CharacterOcid.builder()
                    .characterOcid(characterOcid)
                    .characterName(characterName)
                    .build();
            characterOcidRepository.save(newOcid);

            return characterOcid;
        }
    }

    /**
     * 캐릭터 기본정보, 인기도, 성향, 무릉기록 정보
     */
    @Transactional
    public CharacterBasicTotalInformation getCharacterBasicInfo(String characterName) throws Exception {
        String ocid = getCharacterOcid(characterName);
        Optional<CharacterBasicCache> basicCacheOptional = characterBasicCacheRepository.findById(characterName);

        // 캐시 히트
        if(basicCacheOptional.isPresent()) return basicCacheOptional.orElseThrow().getBasic();

        CharacterBasicInformation characterBasicInformation = characterInformationClient.getCharacterBasicInformation(ocid);
        CharacterPopularity characterPopularity = characterInformationClient.getCharacterPopularity(ocid);
        CharacterPropensity characterPropensity = characterInformationClient.getCharacterPropensity(ocid);
        CharacterDojang characterDojang = characterInformationClient.getCharacterDojang(ocid);

        CharacterBasicTotalInformation basic = new CharacterBasicTotalInformation(characterBasicInformation
                , characterPopularity.popularity()
                , Propensity.toPropensity(characterPropensity)
                , DojangRecord.toDojangRecord(characterDojang));

        CharacterBasicCache newCache = CharacterBasicCache.builder()
                .characterName(characterName)
                .basic(basic)
                .build();

        characterBasicCacheRepository.save(newCache);

        return basic;
    }

    /**
     * 캐릭터 스탯, 하이퍼스탯, 어빌리티 정보
     */
    public CharacterStatTotalInformation getCharacterStatInfo(String characterName) throws Exception {
        String ocid = characterInformationClient.getUserOcid(characterName).ocid();

        Optional<CharacterStatCache> statCacheOptional = characterStatCacheRepository.findById(characterName);

        // 캐시 히트
        if(statCacheOptional.isPresent()) return statCacheOptional.orElseThrow().getStat();

        CharacterStat characterStat = characterInformationClient.getCharacterStat(ocid);
        CharacterHyperStat characterHyperStat = characterInformationClient.getCharacterHyperStat(ocid);
        CharacterAbility characterAbility = characterInformationClient.getCharacterAbility(ocid);

        CharacterStatTotalInformation characterStatTotalInformation = new CharacterStatTotalInformation(characterStat, characterHyperStat, characterAbility);

        CharacterStatCache newCache = CharacterStatCache.builder()
                .characterName(characterName)
                .stat(characterStatTotalInformation)
                .build();

        characterStatCacheRepository.save(newCache);

        return characterStatTotalInformation;
    }

    /**
     * 캐릭터 장비, 심볼, 캐시 장비, 헤어/성형/피부, 안드로이드, 펫, 세트 효과 정보
     */
    public CharacterEquipmentTotalInformation getCharacterEquipmentInfo(String characterName) throws Exception {
        String ocid = characterInformationClient.getUserOcid(characterName).ocid();

        Optional<CharacterEquipmentCache> equipmentCacheOptional = characterEquipmentCacheRepository.findById(characterName);

        // 캐시 히트
        if(equipmentCacheOptional.isPresent()) return equipmentCacheOptional.orElseThrow().getEquipment();

        CharacterItemEquipment characterItemEquipment = characterInformationClient.getCharacterItemEquipment(ocid);
        CharacterSymbolEquipment characterSymbolEquipment = characterInformationClient.getCharacterSymbolEquipment(ocid);
        CharacterCashItemEquipment characterCashItemEquipment = characterInformationClient.getCharacterCashItemEquipment(ocid);
        CharacterBeautyEquipment characterBeautyEquipment = characterInformationClient.getCharacterBeautyEquipment(ocid);
        CharacterAndroidEquipment androidEquipment = characterInformationClient.getAndroidEquipment(ocid);
        CharacterPetEquipment characterPetEquipment = characterInformationClient.getCharacterPetEquipment(ocid);
        CharacterSetEffect characterSetEffect = characterInformationClient.getCharacterSetEffect(ocid);

        CharacterEquipmentTotalInformation characterEquipmentTotalInformation = new CharacterEquipmentTotalInformation(characterItemEquipment, characterSymbolEquipment
                , characterCashItemEquipment, characterBeautyEquipment, androidEquipment
                , characterPetEquipment, characterSetEffect);

        CharacterEquipmentCache newCache = CharacterEquipmentCache.builder()
                .characterName(characterName)
                .equipment(characterEquipmentTotalInformation)
                .build();

        characterEquipmentCacheRepository.save(newCache);

        return characterEquipmentTotalInformation;
    }

    /**
     * 캐릭터 스킬, 링크 스킬, V매트릭스(5차), HEXA 코어(6차) 및 HEXA 스탯 정보 조회
     */
    public CharacterSkillTotalInformation getCharacterSkillInfo(String characterName) throws Exception {
        String ocid = characterInformationClient.getUserOcid(characterName).ocid();

        Optional<CharacterSkillCache> skillCacheOptional = characterSkillCacheRepository.findById(characterName);

        // 캐시 히트
        if(skillCacheOptional.isPresent()) return skillCacheOptional.orElseThrow().getSkill();

        CharacterSkill characterSkill5 = characterInformationClient.getCharacterSkill(ocid, SkillType.SKILL_5.getCode());
        CharacterSkill characterSkill6 = characterInformationClient.getCharacterSkill(ocid, SkillType.SKILL_6.getCode());
        CharacterLinkSkill characterLinkSkill = characterInformationClient.getCharacterLinkSkill(ocid);
        CharacterVMatrix characterVMatrix = characterInformationClient.getCharacterVMatrix(ocid);
        CharacterHexaMatrix characterHexaMatrix = characterInformationClient.getCharacterHexaMatrix(ocid);
        CharacterHexaMatrixStat characterHexaMatrixStat = characterInformationClient.getCharacterHexaMatrixStat(ocid);

        CharacterSkillTotalInformation characterSkillTotalInformation = new CharacterSkillTotalInformation(
                characterSkill5, characterSkill6, characterLinkSkill, characterVMatrix
                ,characterHexaMatrix, characterHexaMatrixStat
        );

        CharacterSkillCache newCache = CharacterSkillCache.builder()
                .characterName(characterName)
                .skill(characterSkillTotalInformation)
                .build();

        characterSkillCacheRepository.save(newCache);

        return characterSkillTotalInformation;
    }
}