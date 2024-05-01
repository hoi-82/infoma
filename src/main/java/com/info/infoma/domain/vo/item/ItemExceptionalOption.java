package com.info.infoma.domain.vo.item;

import com.info.infoma.domain.vo.item.common.ItemBaseStat;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ItemExceptionalOption extends ItemBaseStat {
    private String none;
}
