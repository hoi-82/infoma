package com.info.infoma.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HyperStat {
    private String statType;
    private Integer statPoint;
    private Integer statLevel;
    private String statIncrease;

    @Builder
    public HyperStat(String statType, Integer statPoint, Integer statLevel, String statIncrease) {
        this.statType = statType;
        this.statPoint = statPoint;
        this.statLevel = statLevel;
        this.statIncrease = statIncrease;
    }
}
