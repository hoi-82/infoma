package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.CharacterSymbol;

import java.util.List;

public record CharacterSymbolEquipment(
        String date, String characterClass
        , List<CharacterSymbol> symbol
) {
}
