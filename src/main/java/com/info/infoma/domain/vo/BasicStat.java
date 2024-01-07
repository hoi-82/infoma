package com.info.infoma.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicStat {
    private String statName;
    private String statValue;

    @Builder
    public BasicStat(String statName, String statValue) {
        this.statName = statName;
        this.statValue = statValue;
    }
}
