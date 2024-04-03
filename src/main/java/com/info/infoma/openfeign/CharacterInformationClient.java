package com.info.infoma.openfeign;

import com.info.infoma.configuration.MapleStoryApiConfig;
import com.info.infoma.domain.dto.*;
import com.info.infoma.domain.dto.character.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CharacterInformationClient", url = "${maple-api.host}", configuration = MapleStoryApiConfig.class)
public interface CharacterInformationClient {
    /**
     * 캐릭터 정보(ocid) 조회
     */
    @GetMapping(value = "/maplestory/v1/id")
    UserOcid getUserOcid(@RequestParam("character_name") String characterName);

    /**
     * 캐릭터 기본 정보 조회
      */
    @GetMapping(value = "/maplestory/v1/character/basic")
    CharacterBasicInformation getCharacterBasicInformation(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 인기도 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/popularity")
    CharacterPopularity getCharacterPopularity(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 종합 능력치 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/stat")
    CharacterStat getCharacterStat(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 하이퍼 스탯 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/hyper-stat")
    CharacterHyperStat getCharacterHyperStat(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 성향 정보 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/propensity")
    CharacterPropensity getCharacterPropensity(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 어빌리티 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/ability")
    CharacterAbility getCharacterAbility(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 장착 장비 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/item-equipment")
    CharacterItemEquipment getCharacterItemEquipment(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 장착 캐시 장비 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/cashitem-equipment")
    CharacterCashItemEquipment getCharacterCashItemEquipment(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 장착 심볼 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/symbol-equipment")
    CharacterSymbolEquipment getCharacterSymbolEquipment(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 적용 세트 효과 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/set-effect")
    CharacterSetEffect getCharacterSetEffect(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 장착 헤어, 성형, 피부 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/beauty-equipment")
    CharacterBeautyEquipment getCharacterBeautyEquipment(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 장착 안드로이드 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/android-equipment")
    CharacterAndroidEquipment getAndroidEquipment(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 장착 펫 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/pet-equipment")
    CharacterPetEquipment getCharacterPetEquipment(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 스킬 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/skill")
    CharacterSkill getCharacterSkill(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date
            , @RequestParam("character_skill_grade") String characterSkillGrade);

    /**
     * 장착 링크 스킬 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/link-skill")
    CharacterLinkSkill getCharacterLinkSkill(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * V매트릭스 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/vmatrix")
    CharacterVMatrix getCharacterVMatrix(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * HEXA 코어 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/hexamatrix")
    CharacterHexaMatrix getCharacterHexaMatrix(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * HEXA 매트릭스 설정 HEXA 스탯 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/hexamatrix-stat")
    CharacterHexaMatrixStat getCharacterHexaMatrixStat(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);

    /**
     * 무릉도장 최고 기록 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/dojang")
    CharacterDojang getCharacterDojang(@RequestParam("ocid") String ocid
            , @RequestParam("date") String date);
}
