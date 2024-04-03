package com.info.infoma.domain.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.infoma.domain.vo.stat.HyperStat;

import java.util.List;

public record CharacterHyperStat(
        String date, String characterClass
        , String usePresetNo, Integer useAvailableHyperStat
        , @JsonProperty("hyper_stat_preset_1") List<HyperStat> hyperStatPreset1, @JsonProperty("hyper_stat_preset_1_remain_point") Integer hyperStatPreset1RemainPoint
        , @JsonProperty("hyper_stat_preset_2") List<HyperStat> hyperStatPreset2, @JsonProperty("hyper_stat_preset_2_remain_point") Integer hyperStatPreset2RemainPoint
        , @JsonProperty("hyper_stat_preset_3") List<HyperStat> hyperStatPreset3, @JsonProperty("hyper_stat_preset_3_remain_point") Integer hyperStatPreset3RemainPoint
) {
}
