package com.info.infoma.domain.vo.item;

import com.info.infoma.domain.vo.item.common.ItemBaseUtility;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ItemAddOption extends ItemBaseUtility {
    private String bossDamage;
    private String damage;
    private String allStat;
    private Integer equipmentLevelDecrease;
}
