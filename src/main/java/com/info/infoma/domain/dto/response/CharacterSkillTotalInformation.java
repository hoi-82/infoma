package com.info.infoma.domain.dto.response;

import com.info.infoma.domain.dto.character.*;

public record CharacterSkillTotalInformation(
        CharacterSkill characterSkill5
        , CharacterSkill characterSkill6
        , CharacterLinkSkill characterLinkSkill
        , CharacterVMatrix characterVMatrix
        , CharacterHexaMatrix characterHexaMatrix
        , CharacterHexaMatrixStat characterHexaMatrixStat
) {
}
