package com.info.infoma.domain.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.infoma.domain.vo.item.ItemDragonEquipment;
import com.info.infoma.domain.vo.item.ItemEquipment;
import com.info.infoma.domain.vo.item.ItemMechanicEquipment;
import com.info.infoma.domain.vo.item.ItemTitle;

import java.util.List;

public record CharacterItemEquipment(
        String date, String characterGender, String characterClass
        , Integer presetNo
        , List<ItemEquipment> itemEquipment
        , @JsonProperty(value="item_equipment_preset_1") List<ItemEquipment> itemEquipmentPreset1
        , @JsonProperty(value="item_equipment_preset_2") List<ItemEquipment> itemEquipmentPreset2
        , @JsonProperty(value="item_equipment_preset_3") List<ItemEquipment> itemEquipmentPreset3
        , ItemTitle title
        , List<ItemDragonEquipment> dragonEquipment
        , List<ItemMechanicEquipment> mechanicEquipment
) {
}
