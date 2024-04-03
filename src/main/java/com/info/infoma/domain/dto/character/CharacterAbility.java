package com.info.infoma.domain.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.infoma.domain.vo.stat.AbilityPreset;
import com.info.infoma.domain.vo.stat.AbilityStat;

import java.util.List;

public record CharacterAbility(
        String date, String abilityGrade
        , List<AbilityStat> abilityInfo, Integer remainFame
        , Integer presetNo, @JsonProperty("ability_preset_1") AbilityPreset abilityPreset1
        , @JsonProperty("ability_preset_2") AbilityPreset abilityPreset2, @JsonProperty("ability_preset_3") AbilityPreset abilityPreset3
) {
}
