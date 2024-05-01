package com.info.infoma.domain.vo.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ItemTitle {
    private String titleName;
    private String titleIcon;
    private String titleDescription;
    private String dateExpire;
    private String dateOptionExpire;
}
