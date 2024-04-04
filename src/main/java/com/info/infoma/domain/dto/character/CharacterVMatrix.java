package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.VCoreEquipment;

import java.util.List;

public record CharacterVMatrix(
        String date
        , String characterClass
        , List<VCoreEquipment> characterVCoreEquipment
        , Integer characterVMatrixRemainSlotUpgradePoint
) {
}
