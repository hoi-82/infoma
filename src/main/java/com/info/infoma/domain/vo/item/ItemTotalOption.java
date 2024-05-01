package com.info.infoma.domain.vo.item;

import com.info.infoma.domain.vo.item.common.ItemBaseUtility;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ItemTotalOption extends ItemBaseUtility {
    private String bossDamage;
    private String ignoreMonsterArmor;
    private String allStat;
    private String damage;
    private Integer equipmentLevelDecrease;
    private String maxHpRate;
    private String maxMpRate;
}
