package com.info.infoma.domain.vo.item;

import com.info.infoma.domain.vo.item.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDragonEquipment {
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
    private Integer equipmentLevelIncrease;
    private ItemExceptionalOption itemExceptionalOption;
    private ItemAddOption itemAddOption;
    private Integer growthExp;
    private Integer growthLevel;
    private String scrollUpgrade;
    private String cuttableCount;
    private String goldenHammerFlag;
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
