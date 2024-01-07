package com.info.infoma.domain.dto;

public record CharacterTotalInformation (
        CharacterBasicInformation basicInfo, CharacterStat stat
        , CharacterHyperStat hyperStat, CharacterAbility ability
        , CharacterPopularity popularity, CharacterPropensity propensity
){
}
