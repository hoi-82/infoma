package com.info.infoma.domain.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.infoma.domain.vo.item.CashItemEquipment;

import java.util.List;

public record CharacterCashItemEquipment(
        String date, String characterGender
        , String characterClass, Integer presetNo
        , List<CashItemEquipment> cashItemEquipmentBase
        , @JsonProperty("cash_item_equipment_preset_1") List<CashItemEquipment> cashItemEquipmentPreset1
        , @JsonProperty("cash_item_equipment_preset_2") List<CashItemEquipment> cashItemEquipmentPreset2
        , @JsonProperty("cash_item_equipment_preset_3") List<CashItemEquipment> cashItemEquipmentPreset3
        , List<CashItemEquipment> additionalCashItemEquipmentBase
        , @JsonProperty("additional_cash_item_equipment_preset_1") List<CashItemEquipment> additionalCashItemEquipmentPreset1
        , @JsonProperty("additional_cash_item_equipment_preset_2") List<CashItemEquipment> additionalCashItemEquipmentPreset2
        , @JsonProperty("additional_cash_item_equipment_preset_3") List<CashItemEquipment> additionalCashItemEquipmentPreset3
) {
}
