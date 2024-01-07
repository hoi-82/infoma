package com.info.infoma.domain.dto;

import com.info.infoma.domain.vo.HyperStat;

import java.util.List;

public record CharacterHyperStat(
        String date, String characterClass
        , String usePresetNo, Integer useAvailableHyperStat
        , List<HyperStat> hyperStatPreset1, Integer hyperStatPreset1RemainPoint
        , List<HyperStat> hyperStatPreset2, Integer hyperStatPreset2RemainPoint
        , List<HyperStat> hyperStatPreset3, Integer hyperStatPreset3RemainPoint
) {
}
