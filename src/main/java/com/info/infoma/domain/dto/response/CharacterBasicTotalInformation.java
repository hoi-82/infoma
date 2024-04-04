package com.info.infoma.domain.dto.response;

import com.info.infoma.domain.dto.character.CharacterBasicInformation;
import com.info.infoma.domain.vo.DojangRecord;
import com.info.infoma.domain.vo.Propensity;
import lombok.Getter;

public record CharacterBasicTotalInformation(
        CharacterBasicInformation characterBasicInformation, String popularity
        , Propensity propensity, DojangRecord dojangRecord
) {
}
