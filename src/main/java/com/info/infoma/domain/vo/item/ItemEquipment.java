package com.info.infoma.domain.vo.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ItemEquipment {
    private String itemEquipmentPart;
    private String itemEquipmentSlot;
    private String itemName;
    private String itemIcon;
    private String itemDescription;
    private String itemShapeName;
    private String itemShapeIcon;
    private String itemGender;
    private ItemTotalOption itemTotalOption;
    private ItemBaseOption itemBaseOption;
    private String potentialOptionGrade;
    private String additionalPotentialOptionGrade;
    @JsonProperty(value = "potential_option_1")
    private String potentialOption1;
    @JsonProperty(value = "potential_option_2")
    private String potentialOption2;
    @JsonProperty(value = "potential_option_3")
    private String potentialOption3;
    @JsonProperty(value = "additional_potential_option_1")
    private String additionalPotentialOption1;
    @JsonProperty(value = "additional_potential_option_2")
    private String additionalPotentialOption2;
    @JsonProperty(value = "additional_potential_option_3")
    private String additionalPotentialOption3;
    private Integer equipmentLevelIncrease;
    private ItemExceptionalOption itemExceptionalOption;
    private ItemAddOption itemAddOption;
    private Integer growthExp;
    private Integer growthLevel;
    private String scrollUpgrade;
    private String cuttableCount;
    private String goldenHammerFlg;
    private String scrollResilienceCount;
    private String scrollUpgradeableCount;
    private String soulName;
    private String soulOption;
    private ItemEtcOption itemEtcOption;
    private String starforce;
    private String starforceScrollFlag;
    private ItemStarforceOption itemStarforceOption;
    private Integer specialRingLevel;
    private String dateExpire;
}
