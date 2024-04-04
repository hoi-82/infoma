package com.info.infoma.domain.vo.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PetSkill {
    @JsonProperty("skill_1")
    private String skill1;

    @JsonProperty("skill_1_icon")
    private String skill1Icon;

    @JsonProperty("skill_2")
    private String skill2;

    @JsonProperty("skill_2_icon")
    private String skill2Icon;
}
