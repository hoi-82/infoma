package com.info.infoma.controller.api;

import com.info.infoma.domain.dto.CharacterTotalInformation;
import com.info.infoma.service.BasicInformationService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "rest/")
@RequiredArgsConstructor
public class BasicInformationController {
    private final BasicInformationService basicInformationService;

    @GetMapping(value = "/character/{character_name}")
    @Validated
    public ResponseEntity<CharacterTotalInformation> fireOcid(@NotEmpty @PathVariable("character_name") String characterName) throws Exception {
        return ResponseEntity.ok(basicInformationService.getCharacterInformation(characterName));
    }

}