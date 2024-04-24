package com.info.infoma.controller.api;

import com.info.infoma.domain.dto.response.*;
import com.info.infoma.service.CharacterInformationService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 캐릭터 정보 조회 Endpoint
 *
 */
@RestController
@RequestMapping(value = "/api/v1/char")
@RequiredArgsConstructor
@Slf4j
public class CharacterInformationController {
    private final CharacterInformationService characterInformationService;

    /**
     * 캐릭터 기본정보, 인기도, 성향, 무릉기록 정보
     */
    @GetMapping(value = "/basic/{character_name}")
    @Validated
    public ResponseEntity<?> getBasic(@NotEmpty @PathVariable("character_name") String characterName) throws Exception {
        log.debug("[기본 정보 조회] 캐릭터 명 : {}", characterName);
        return ResponseEntity.ok(SuccessResponse.<CharacterBasicTotalInformation>builder()
                .status(true)
                .message("캐릭터 기본 정보를 불러오는데 성공하였습니다.")
                .data(characterInformationService.getCharacterBasicInfo(characterName))
                .build()
        );
    }

    /**
     * 최근 조회 Short 정보
     */
    @GetMapping(value = "/short")
    public ResponseEntity<?> getShort() throws Exception {
        log.debug("[최근 캐릭터 Short 리스트] 조회");
        return ResponseEntity.ok(SuccessResponse.<List<CharacterBasicTotalInformation>>builder()
                .status(true)
                .message("최근 조회 Short 정보를 불러오는데 성공하였습니다.")
                .data(characterInformationService.getCharacterShort())
                .build()
        );
    }

    /**
     * 캐릭터 스탯, 하이퍼스탯, 어빌리티 정보
     */
    @GetMapping(value = "/stat/{character_name}")
    @Validated
    public ResponseEntity<?> getStat(@NotEmpty @PathVariable("character_name") String characterName) throws Exception {
        log.debug("[스탯 정보 조회] 캐릭터 명 : {}", characterName);
        return ResponseEntity.ok(SuccessResponse.<CharacterStatTotalInformation>builder()
                .status(true)
                .message("캐릭터 스탯 정보를 불러오는데 성공하였습니다.")
                .data(characterInformationService.getCharacterStatInfo(characterName))
                .build()
        );
    }

    /**
     * 캐릭터 장비, 심볼, 캐시 장비, 헤어/성형/피부, 안드로이드, 펫, 세트 효과 정보
     */
    @GetMapping(value = "/equipment/{character_name}")
    @Validated
    public ResponseEntity<?> getEquipment(@NotEmpty @PathVariable("character_name") String characterName) throws Exception {
        log.debug("[장비 정보 조회] 캐릭터 명 : {}", characterName);
        return ResponseEntity.ok(SuccessResponse.<CharacterEquipmentTotalInformation>builder()
                .status(true)
                .message("캐릭터 장비 정보를 불러오는데 성공하였습니다.")
                .data(characterInformationService.getCharacterEquipmentInfo(characterName))
                .build()
        );
    }

    /**
     * 캐릭터 스킬, 링크 스킬, V매트릭스(5차), HEXA 코어(6차) 및 HEXA 스탯 정보 조회
     */
    @GetMapping(value = "/skill/{character_name}")
    @Validated
    public ResponseEntity<?> getSkill(@NotEmpty @PathVariable("character_name") String characterName) throws Exception {
        log.debug("[스킬 정보 조회] 캐릭터 명 : {}", characterName);
        return ResponseEntity.ok(SuccessResponse.<CharacterSkillTotalInformation>builder()
                .status(true)
                .message("캐릭터 스킬 정보를 불러오는데 성공하였습니다.")
                .data(characterInformationService.getCharacterSkillInfo(characterName))
                .build()
        );
    }


}