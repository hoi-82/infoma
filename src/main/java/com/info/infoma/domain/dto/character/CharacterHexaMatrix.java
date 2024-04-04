package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.HexaCoreEquipment;

import java.util.List;

public record CharacterHexaMatrix(
        String date
        , List<HexaCoreEquipment> characterHexaCoreEquipment
) {
}
