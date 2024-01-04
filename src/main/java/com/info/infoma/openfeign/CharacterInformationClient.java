package com.info.infoma.openfeign;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.info.infoma.configuration.MapleStoryApiConfig;
import com.info.infoma.domain.dto.CharacterBasicInformation;
import com.info.infoma.domain.dto.UserOcid;
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
}
