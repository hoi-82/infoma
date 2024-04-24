package com.info.infoma.domain.dto.character;

public record CharacterBasicInformation(
        String characterName
        , String worldName, String characterGender
        , String characterClass, String characterClassLevel
        , Integer characterLevel, Long characterExp
        , String characterExpRate, String characterGuildName
        , String characterImage
) {
}