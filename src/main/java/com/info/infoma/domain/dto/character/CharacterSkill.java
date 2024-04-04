package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.Skill;

import java.util.List;

public record CharacterSkill(
        String date
        , String characterClass
        , String characterSkillGrade
        , List<Skill> characterSkill
) {
}
