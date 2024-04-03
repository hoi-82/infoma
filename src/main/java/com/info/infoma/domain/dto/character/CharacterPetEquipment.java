package com.info.infoma.domain.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.infoma.domain.vo.item.PetEquipment;
import com.info.infoma.domain.vo.skill.PetSkill;

import java.util.List;

public record CharacterPetEquipment(
        String date
        , @JsonProperty("pet_1_name") String pet1Name
        , @JsonProperty("pet_1_nickname") String pet1NickName
        , @JsonProperty("pet_1_icon") String pet1Icon
        , @JsonProperty("pet_1_description") String pet1Description
        , @JsonProperty("pet_1_equipment") PetEquipment pet1Equipment
        , @JsonProperty("pet_1_auto_skill") PetSkill pet1AutoSkill
        , @JsonProperty("pet_1_pet_type") String pet1PetType
        , @JsonProperty("pet_1_skill") List<String> pet1Skill
        , @JsonProperty("pet_1_date_expire") String pet1DateExpire
        , @JsonProperty("pet_1_appearance") String pet1Appearance
        , @JsonProperty("pet_1_appearance_icon") String pet1AppearanceIcon
        , @JsonProperty("pet_2_name") String pet2Name
        , @JsonProperty("pet_2_nickname") String pet2NickName
        , @JsonProperty("pet_2_icon") String pet2Icon
        , @JsonProperty("pet_2_description") String pet2Description
        , @JsonProperty("pet_2_equipment") PetEquipment pet2Equipment
        , @JsonProperty("pet_2_auto_skill") PetSkill pet2AutoSkill
        , @JsonProperty("pet_2_pet_type") String pet2PetType
        , @JsonProperty("pet_2_skill") List<String> pet2Skill
        , @JsonProperty("pet_2_date_expire") String pet2DateExpire
        , @JsonProperty("pet_2_appearance") String pet2Appearance
        , @JsonProperty("pet_2_appearance_icon") String pet2AppearanceIcon
        , @JsonProperty("pet_3_name") String pet3Name
        , @JsonProperty("pet_3_nickname") String pet3NickName
        , @JsonProperty("pet_3_icon") String pet3Icon
        , @JsonProperty("pet_3_description") String pet3Description
        , @JsonProperty("pet_3_equipment") PetEquipment pet3Equipment
        , @JsonProperty("pet_3_auto_skill") PetSkill pet3AutoSkill
        , @JsonProperty("pet_3_pet_type") String pet3PetType
        , @JsonProperty("pet_3_skill") List<String> pet3Skill
        , @JsonProperty("pet_3_date_expire") String pet3DateExpire
        , @JsonProperty("pet_3_appearance") String pet3Appearance
        , @JsonProperty("pet_3_appearance_icon") String pet3AppearanceIcon
        ) {
}
