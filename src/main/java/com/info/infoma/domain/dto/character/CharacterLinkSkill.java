package com.info.infoma.domain.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.infoma.domain.vo.Skill;

import java.util.List;

public record CharacterLinkSkill(
        String date
        , String characterClass
        , Skill characterLinkSkill
        , @JsonProperty("character_link_skill_preset_1") List<Skill> characterLinkSkillPreset1
        , @JsonProperty("character_link_skill_preset_2") List<Skill> characterLinkSkillPreset2
        , @JsonProperty("character_link_skill_preset_3") List<Skill> characterLinkSkillPreset3
        , List<Skill> characterOwnedLinkSkill
        , @JsonProperty("character_owned_link_skill_preset_1") List<Skill> characterOwnedLinkSkillPreset1
        , @JsonProperty("character_owned_link_skill_preset_2") List<Skill> characterOwnedLinkSkillPreset2
        , @JsonProperty("character_owned_link_skill_preset_3") List<Skill> characterOwnedLinkSkillPreset3
) {
}
