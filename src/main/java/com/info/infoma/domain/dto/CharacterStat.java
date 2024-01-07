package com.info.infoma.domain.dto;

import com.info.infoma.domain.vo.BasicStat;

import java.util.List;

public record CharacterStat(
        String date, String characterClass
        , List<BasicStat> stat, Integer remainAp
) {
}
