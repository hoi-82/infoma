package com.info.infoma.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Skill {
    private String skillName;
    private String skillDescription;
    private Integer skillLevel;
    private String skillEffect;
    private String skillIcon;
}
