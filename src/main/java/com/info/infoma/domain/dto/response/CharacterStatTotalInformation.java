package com.info.infoma.domain.dto.response;

import com.info.infoma.domain.dto.character.CharacterAbility;
import com.info.infoma.domain.dto.character.CharacterHyperStat;
import com.info.infoma.domain.dto.character.CharacterStat;
import lombok.Getter;

public record CharacterStatTotalInformation(
        CharacterStat characterStat, CharacterHyperStat characterHyperStat, CharacterAbility characterAbility
) {
}
