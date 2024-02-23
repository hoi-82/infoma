package com.info.infoma.domain.dto;

import com.info.infoma.domain.vo.item.ItemDragonEquipment;
import com.info.infoma.domain.vo.item.ItemEquipment;
import com.info.infoma.domain.vo.item.ItemMechanicEquipment;
import com.info.infoma.domain.vo.item.ItemTitle;

import java.util.List;

public record CharacterItemEquipment(
        String date, String characterGender, String characterClass
        , List<ItemEquipment> itemEquipment
        , ItemTitle title
        , List<ItemDragonEquipment> dragonEquipment
        , List<ItemMechanicEquipment> mechanicEquipment
) {
}
