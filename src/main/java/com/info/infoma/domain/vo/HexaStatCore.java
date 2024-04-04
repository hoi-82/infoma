package com.info.infoma.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HexaStatCore {
    private String slotId;
    private String mainStatName;
    @JsonProperty("sub_stat_name_1")
    private String subStatName1;
    @JsonProperty("sub_stat_name_2")
    private String subStatName2;
    private Integer mainStatLevel;
    @JsonProperty("sub_stat_level_1")
    private Integer subStatLevel1;
    @JsonProperty("sub_stat_level_2")
    private Integer subStatLevel2;
    private Integer statGrade;

}
