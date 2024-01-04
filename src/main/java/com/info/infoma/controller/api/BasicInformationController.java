package com.info.infoma.controller.api;

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

    @GetMapping(value = "/id/{character_name}")
    @Validated
    public ResponseEntity<String> fireOcid(@NotEmpty @PathVariable("character_name") String characterName) throws Exception {
        return ResponseEntity.ok(basicInformationService.getOcid(characterName));
    }

}
