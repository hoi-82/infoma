package com.info.infoma.domain.vo.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ColoringPrism {
    private String colorRange;
    private Integer hue;
    private Integer saturation;
    private Integer value;
}
