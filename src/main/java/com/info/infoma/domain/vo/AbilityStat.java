package com.info.infoma.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbilityStat {
    private String abilityNo;
    private String abilityGrade;
    private String abilityValue;

    @Builder
    public AbilityStat(String abilityNo, String abilityGrade, String abilityValue) {
        this.abilityNo = abilityNo;
        this.abilityGrade = abilityGrade;
        this.abilityValue = abilityValue;
    }
}
