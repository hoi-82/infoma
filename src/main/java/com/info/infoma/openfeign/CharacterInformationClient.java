package com.info.infoma.openfeign;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.info.infoma.configuration.MapleStoryApiConfig;
import com.info.infoma.domain.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "CharacterInformationClient", url = "${maple-api.service.host}", configuration = MapleStoryApiConfig.class)
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
            , @JsonFormat(pattern = "yyyy-mm-dd") @RequestParam("date") LocalDate date);

    /**
     * 인기도 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/popularity")
    CharacterPopularity getCharacterPopularity(@RequestParam("ocid") String ocid
            , @JsonFormat(pattern = "yyyy-mm-dd") @RequestParam("date") LocalDate date);

    /**
     * 종합 능력치 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/stat")
    CharacterStat getCharacterStat(@RequestParam("ocid") String ocid
            , @JsonFormat(pattern = "yyyy-mm-dd") @RequestParam("date") LocalDate date);

    /**
     * 하이퍼 스탯 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/hyper-stat")
    CharacterHyperStat getCharacterHyperStat(@RequestParam("ocid") String ocid
            , @JsonFormat(pattern = "yyyy-mm-dd") @RequestParam("date") LocalDate date);

    /**
     * 성향 정보 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/propensity")
    CharacterPropensity getCharacterPropensity(@RequestParam("ocid") String ocid
            , @JsonFormat(pattern = "yyyy-mm-dd") @RequestParam("date") LocalDate date);

    /**
     * 어빌리티 정보 조회
     */
    @GetMapping(value = "/maplestory/v1/character/ability")
    CharacterAbility getCharacterAbility(@RequestParam("ocid") String ocid
            , @JsonFormat(pattern = "yyyy-mm-dd") @RequestParam("date") LocalDate date);
}
