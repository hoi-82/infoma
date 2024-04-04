package com.info.infoma.domain.vo.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CashItemEquipment {
    private String cashItemEquipmentPart;
    private String cashItemEquipmentSlot;
    private String cashItemName;
    private String cashItemIcon;
    private String cashItemDescription;
    private List<ItemOption> cashItemOption;
    private String dateExpire;
    private String dateOptionExpire;
    private String cashItemLabel;
    private ColoringPrism cashItemColoringPrism;
    private String itemGender;
}
