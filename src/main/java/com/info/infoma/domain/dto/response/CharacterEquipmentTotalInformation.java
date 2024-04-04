package com.info.infoma.domain.dto.response;

import com.info.infoma.domain.dto.character.*;

public record CharacterEquipmentTotalInformation(
        CharacterItemEquipment characterItemEquipment
        , CharacterSymbolEquipment characterSymbolEquipment
        , CharacterCashItemEquipment characterCashItemEquipment
        , CharacterBeautyEquipment characterBeautyEquipment
        , CharacterAndroidEquipment androidEquipment
        , CharacterPetEquipment characterPetEquipment
        , CharacterSetEffect characterSetEffect
) {
}
