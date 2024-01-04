package com.info.infoma.domain.dto;

public record CharacterBasicInformation(
        String date, String characterName
        , String worldName, String characterGender
        , String characterClass, String characterClassLevel
        , Integer characterLevel, Long characterExp
        , String characterExpRate, String characterGuildName
        , String characterImage
) {
}
