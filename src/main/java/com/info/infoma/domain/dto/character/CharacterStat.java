package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.stat.BasicStat;

import java.util.List;

public record CharacterStat(
        String date, String characterClass
        , List<BasicStat> finalStat, Integer remainAp
) {
}
