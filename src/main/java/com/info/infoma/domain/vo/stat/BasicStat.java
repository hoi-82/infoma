package com.info.infoma.domain.vo.stat;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BasicStat {
    private String statName;
    private String statValue;

    @Builder
    public BasicStat(String statName, String statValue) {
        this.statName = statName;
        this.statValue = statValue;
    }
}
