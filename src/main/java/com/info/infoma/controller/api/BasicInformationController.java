package com.info.infoma.controller.api;

import com.info.infoma.domain.dto.CharacterTotalInformation;
import com.info.infoma.service.BasicInformationService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "info/basic")
@RequiredArgsConstructor
public class BasicInformationController {
    private final BasicInformationService basicInformationService;

    @GetMapping(value = "/character/{character_name}")
    @Validated
    public ResponseEntity<CharacterTotalInformation> fireOcid(@NotEmpty @PathVariable("character_name") String characterName) throws Exception {
        return ResponseEntity.ok(basicInformationService.getCharacterInformation(characterName));
    }

}
