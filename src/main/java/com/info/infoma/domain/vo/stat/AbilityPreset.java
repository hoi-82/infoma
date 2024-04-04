package com.info.infoma.domain.vo.stat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class AbilityPreset {
    private String abilityPresetGrade;
    private List<AbilityStat> abilityInfo;
}
