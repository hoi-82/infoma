package com.info.infoma.service;

import com.info.infoma.domain.dto.character.*;
import com.info.infoma.domain.dto.response.CharacterBasicTotalInformation;
import com.info.infoma.domain.dto.response.CharacterEquipmentTotalInformation;
import com.info.infoma.domain.dto.response.CharacterSkillTotalInformation;
import com.info.infoma.domain.dto.response.CharacterStatTotalInformation;
import com.info.infoma.domain.enums.SkillType;
import com.info.infoma.domain.vo.DojangRecord;
import com.info.infoma.domain.vo.Propensity;
import com.info.infoma.openfeign.CharacterInformationClient;
import com.info.infoma.repository.CharacterInfoCacheRepository;
import com.info.infoma.repository.CharacterOcidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CharacterInformationService {

    private final CharacterInformationClient characterInformationClient;
    private final CharacterOcidRepository characterOcidRepository;
    private final CharacterInfoCacheRepository characterInfoCacheRepository;

    /**
     * 캐릭터 기본정보, 인기도, 성향, 무릉기록 정보
     */
    public CharacterBasicTotalInformation getCharacterBasicInfo(String characterName) throws Exception {
        String ocid = characterInformationClient.getUserOcid(characterName).ocid();
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        CharacterBasicInformation characterBasicInformation = characterInformationClient.getCharacterBasicInformation(ocid, yesterday);
        CharacterPopularity characterPopularity = characterInformationClient.getCharacterPopularity(ocid, yesterday);
        CharacterPropensity characterPropensity = characterInformationClient.getCharacterPropensity(ocid, yesterday);
        CharacterDojang characterDojang = characterInformationClient.getCharacterDojang(ocid, yesterday);

        return new CharacterBasicTotalInformation(characterBasicInformation
                , characterPopularity.popularity()
                , Propensity.toPropensity(characterPropensity)
                , DojangRecord.toDojangRecord(characterDojang));
    }

    /**
     * 캐릭터 스탯, 하이퍼스탯, 어빌리티 정보
     */
    public CharacterStatTotalInformation getCharacterStatInfo(String characterName) throws Exception {
        String ocid = characterInformationClient.getUserOcid(characterName).ocid();
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        CharacterStat characterStat = characterInformationClient.getCharacterStat(ocid, yesterday);
        CharacterHyperStat characterHyperStat = characterInformationClient.getCharacterHyperStat(ocid, yesterday);
        CharacterAbility characterAbility = characterInformationClient.getCharacterAbility(ocid, yesterday);

        return new CharacterStatTotalInformation(characterStat, characterHyperStat, characterAbility);
    }

    /**
     * 캐릭터 장비, 심볼, 캐시 장비, 헤어/성형/피부, 안드로이드, 펫, 세트 효과 정보
     */
    public CharacterEquipmentTotalInformation getCharacterEquipmentInfo(String characterName) throws Exception {
        String ocid = characterInformationClient.getUserOcid(characterName).ocid();
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        CharacterItemEquipment characterItemEquipment = characterInformationClient.getCharacterItemEquipment(ocid, yesterday);
        CharacterSymbolEquipment characterSymbolEquipment = characterInformationClient.getCharacterSymbolEquipment(ocid, yesterday);
        CharacterCashItemEquipment characterCashItemEquipment = characterInformationClient.getCharacterCashItemEquipment(ocid, yesterday);
        CharacterBeautyEquipment characterBeautyEquipment = characterInformationClient.getCharacterBeautyEquipment(ocid, yesterday);
        CharacterAndroidEquipment androidEquipment = characterInformationClient.getAndroidEquipment(ocid, yesterday);
        CharacterPetEquipment characterPetEquipment = characterInformationClient.getCharacterPetEquipment(ocid, yesterday);
        CharacterSetEffect characterSetEffect = characterInformationClient.getCharacterSetEffect(ocid, yesterday);

        return new CharacterEquipmentTotalInformation(characterItemEquipment, characterSymbolEquipment
                , characterCashItemEquipment, characterBeautyEquipment, androidEquipment
                , characterPetEquipment, characterSetEffect);
    }

    /**
     * 캐릭터 스킬, 링크 스킬, V매트릭스(5차), HEXA 코어(6차) 및 HEXA 스탯 정보 조회
     */
    public CharacterSkillTotalInformation getCharacterSkillInfo(String characterName) throws Exception {
        String ocid = characterInformationClient.getUserOcid(characterName).ocid();
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        CharacterSkill characterSkill5 = characterInformationClient.getCharacterSkill(ocid, yesterday, SkillType.SKILL_5.getCode());
        CharacterSkill characterSkill6 = characterInformationClient.getCharacterSkill(ocid, yesterday, SkillType.SKILL_6.getCode());
        CharacterLinkSkill characterLinkSkill = characterInformationClient.getCharacterLinkSkill(ocid, yesterday);
        CharacterVMatrix characterVMatrix = characterInformationClient.getCharacterVMatrix(ocid, yesterday);
        CharacterHexaMatrix characterHexaMatrix = characterInformationClient.getCharacterHexaMatrix(ocid, yesterday);
        CharacterHexaMatrixStat characterHexaMatrixStat = characterInformationClient.getCharacterHexaMatrixStat(ocid, yesterday);

        return new CharacterSkillTotalInformation();
    }
}
