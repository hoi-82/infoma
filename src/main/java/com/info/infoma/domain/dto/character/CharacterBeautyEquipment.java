package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.Face;
import com.info.infoma.domain.vo.Hair;

public record CharacterBeautyEquipment(
        String date
        , String characterGender
        , String characterClass
        , Hair characterHair
        , Face characterFace
        , String characterSkinName
        , Hair additionalCharacterHair
        , Face additionalCharacterFace
        , String additionalCharacterSkinName
) {
}
