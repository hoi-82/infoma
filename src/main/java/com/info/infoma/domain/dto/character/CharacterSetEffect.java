package com.info.infoma.domain.dto.character;

import com.info.infoma.domain.vo.SetEffect;

import java.util.List;

public record CharacterSetEffect(
        String date
        , List<SetEffect> setEffect
) {
}
