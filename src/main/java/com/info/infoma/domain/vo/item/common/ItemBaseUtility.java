package com.info.infoma.domain.vo.item.common;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ItemBaseUtility extends ItemBaseStat {
    private String armor;
    private String speed;
    private String jump;
}
