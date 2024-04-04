package com.info.infoma.domain.vo;

import com.info.infoma.domain.dto.character.CharacterPropensity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Propensity {
    private int charismaLevel; // 카리스마
    private int sensibilityLevel; // 감성
    private int insightLevel; // 통찰력
    private int willingnessLevel; // 의지
    private int handicraftLevel; // 손재주
    private int charmLevel; // 매력

    public static Propensity toPropensity(CharacterPropensity characterPropensity) {
        return Propensity.builder()
                .charismaLevel(characterPropensity.charismaLevel())
                .sensibilityLevel(characterPropensity.sensibilityLevel())
                .insightLevel(characterPropensity.insightLevel())
                .willingnessLevel(characterPropensity.willingnessLevel())
                .handicraftLevel(characterPropensity.handicraftLevel())
                .charmLevel(characterPropensity.charmLevel())
                .build();
    }
}
