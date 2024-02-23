package com.info.infoma.domain.vo.item.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ItemBaseStat {
    private String str;
    private String dex;
    @JsonProperty(value = "int")
    private String statInt;
    private String luk;
    private String maxHp;
    private String maxMp;
    private String attackPower;
    private String magicPower;
}