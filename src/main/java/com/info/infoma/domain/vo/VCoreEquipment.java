package com.info.infoma.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VCoreEquipment {
    private String slotId;
    private Integer slotLevel;
    private String vCoreName;
    private String vCoreType;
    private Integer vCoreLevel;
    @JsonProperty("v_core_skill_1")
    private String vCoreSkill1;
    @JsonProperty("v_core_skill_2")
    private String vCoreSkill2;
    @JsonProperty("v_core_skill_3")
    private String vCoreSkill3;
}
