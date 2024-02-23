package com.info.infoma.domain.vo;

import com.info.infoma.domain.enums.SymbolType;
import lombok.*;

@Getter
@Setter
public class CharacterSymbol {
    private String symbolName;
    private String symbolIcon;
    private String symbolDescription;
    private String symbolForce;
    private Integer symbolLevel;
    private String symbolStr;
    private String symbolDex;
    private String symbolInt;
    private String symbolLuk;
    private String symbolHp;
    private Integer symbolGrowthCount;
    private Integer symbolRequireGrowthCount;

    private String symbolState;
    private SymbolType symbolType;
    private Double symbolPer;
    private Integer symbolRemainForMax;
}
