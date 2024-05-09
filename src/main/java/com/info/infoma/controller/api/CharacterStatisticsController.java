package com.info.infoma.controller.api;

import com.info.infoma.domain.dto.CharacterLevelDto;
import com.info.infoma.domain.dto.response.CharacterEquipmentTotalInformation;
import com.info.infoma.domain.dto.response.SuccessResponse;
import com.info.infoma.service.CharacterStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/statistics")
public class CharacterStatisticsController {
    private final CharacterStatisticsService characterStatisticsService;

    @GetMapping("/char/level/{character_name}")
    public ResponseEntity<?> getCharacterLevelStatistics(@PathVariable("character_name") String characterName) throws Exception {
        return ResponseEntity.ok(SuccessResponse.<List<CharacterLevelDto>>builder()
                .status(true)
                .message("캐릭터 레벨/경험치 통계를 불러오는데 성공하였습니다.")
                .data(characterStatisticsService.findCharacterLevelAndExpNear5Days(characterName))
                .build());
    }
}
