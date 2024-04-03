package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.Face;
import com.info.infoma.domain.vo.Hair;
import com.info.infoma.domain.vo.item.CashItemEquipment;

import java.util.List;

public record CharacterAndroidEquipment(
        String date
        , String androidName
        , String androidNickName
        , String androidIcon
        , String androidDescription
        , Hair androidHair
        , Face androidFace
        , String androidSkinName
        , List<CashItemEquipment> androidCashItemEquipment
        , String androidEarSensorClipFlag
        , String androidGender
        , String androidGrade
        , String androidNonHumanoidFlag
        , String androidShopUsableFlag
        , Integer presetNo
) {
}
