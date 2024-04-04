package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.HexaStatCore;

import java.util.List;

public record CharacterHexaMatrixStat(
        String date
        , String characterClass
        , List<HexaStatCore> characterHexaStatCore
        , List<HexaStatCore> presetHexaStatCore
) {
}
