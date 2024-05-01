package com.info.infoma.domain.vo.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ItemOption {
    private String optionType;
    private String optionValue;
}
