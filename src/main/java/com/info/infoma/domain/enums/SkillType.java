package com.info.infoma.domain.enums;

import lombok.Getter;

@Getter
public enum SkillType {
    SKILL_0("0", "0차 스킬 및 제로 공용스킬")
    , SKILL_1("1", "1차 스킬")
    , SKILL_1_5("1.5", "1.5차 스킬")
    , SKILL_2("2", "2차 스킬")
    , SKILL_2_5("2.5", "2.5차 스킬")
    , SKILL_3("3", "3차 스킬")
    , SKILL_4("4", "4차 스킬 및 제로 알파/베타 스킬")
    , SKILL_HYPER_PASSIVE("hyperpassive", "하이퍼 패시브 스킬")
    , SKILL_HYPER_ACTIVE("hyperactive", "하이퍼 액티브 스킬")
    , SKILL_5("5", "5차 스킬")
    , SKILL_6("6", "6차 스킬")
    ;

    private final String code;
    private final String name;

    SkillType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
