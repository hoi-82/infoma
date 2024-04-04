package com.info.infoma.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class SetEffect {
    private String setName;
    private Integer totalSetCount;
    private List<SetEffectInfo> setEffectInfo;
}
