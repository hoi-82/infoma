package com.info.infoma.controller;

import com.info.infoma.service.BasicInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "info/")
@Controller
@RequiredArgsConstructor
public class test {
    private final BasicInformationService basicInformationService;

    @GetMapping(value = "/char")
    public String idxPg() throws Exception {
        return "index";
    }

    @GetMapping(value = "/char/{characterName}")
    public String characterInfoPage(@PathVariable("characterName") String characterName
        , Model model) throws Exception {

        model.addAttribute("character", basicInformationService.getCharacterInformation(characterName));

        return "index";
    }

}
