package com.info.infoma.domain.vo.item;

import com.info.infoma.domain.vo.item.common.ItemBaseUtility;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ItemBaseOption extends ItemBaseUtility {
    private String bossDamage;
    private String ignoreMonsterArmor;
    private String allStat;
    private String maxHpRate;
    private String maxMpRate;
    private String baseEquipmentLevel;
}
