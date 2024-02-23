package com.info.infoma.domain.dto;

import com.info.infoma.domain.vo.stat.AbilityStat;

import java.util.List;

public record CharacterAbility(
        String date, String abilityGrade
        , List<AbilityStat> abilityInfo, Integer remainFame
) {
}
