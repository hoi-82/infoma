package com.info.infoma.domain.vo.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PetEquipment {
    private String itemName;
    private String itemIcon;
    private String itemDescription;
    private List<ItemOption> itemOption;
    private Integer scrollUpgrade;
    private Integer scrollUpgradable;
    private String itemShape;
    private String itemShapeIcon;
}
