package com.info.infoma.domain.enums;

import lombok.Getter;

@Getter
public enum SymbolType {
    ARC("아케인심볼", "ARC")
    , ACT("어센틱심볼", "ACT")
    ;

    private final String symbolName;
    private final String symbolEngName;

    SymbolType(String symbolName, String symbolEngName) {
        this.symbolName = symbolName;
        this.symbolEngName = symbolEngName;
    }
}
