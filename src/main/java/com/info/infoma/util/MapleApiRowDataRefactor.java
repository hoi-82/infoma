package com.info.infoma.util;

import com.info.infoma.domain.enums.SymbolType;
import com.info.infoma.domain.vo.CharacterSymbol;

public class MapleApiRowDataRefactor {
    public static void symbolRefactor(CharacterSymbol symbol) {
        symbol.setSymbolType(checkSymbolType(symbol.getSymbolName()));
        symbol.setSymbolState("");
    }

    // 심볼 타입 매칭
    private static SymbolType checkSymbolType(String symbolName) {
        SymbolType type = null;

        if(symbolName.contains(SymbolType.ARC.getSymbolName())) type = SymbolType.ARC;
        else if(symbolName.contains(SymbolType.ACT.getSymbolName())) type = SymbolType.ACT;

        return type;
    }
}
