package com.info.infoma.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HexaCoreEquipment {
    private String hexaCoreName;
    private Integer hexaCoreLevel;
    private String hexaCoreType;
    private List<LinkedSkill> linkedSkill;
}
