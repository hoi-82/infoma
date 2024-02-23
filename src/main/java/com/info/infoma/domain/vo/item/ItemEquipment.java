package com.info.infoma.domain.vo.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class ItemEquipment {
    private String itemEquipmentPart;
    private String equipmentSlot;
    private String itemName;
    private String itemIcon;
    private String itemDescription;
    private String itemShapeName;
    private String itemShapeIcon;
    private String gender;
    private ItemTotalOption itemTotalOption;
    private ItemBaseOption itemBaseOption;
    private String potentialOptionGrade;
    private String additionalPotentialOptionGrade;
    private String potentialOption1;
    private String potentialOption2;
    private String potentialOption3;
    private String additionalPotentialOption1;
    private String additionalPotentialOption2;
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
    private LocalDateTime dateExpire;
}
