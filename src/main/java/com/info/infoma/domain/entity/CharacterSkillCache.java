package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.response.CharacterSkillTotalInformation;
import com.info.infoma.domain.entity.common.CharacterCommonCache;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "character_skill", timeToLive = 600L)
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterSkillCache extends CharacterCommonCache {
    @Id
    @Column(name = "char_name")
    private String characterName;

    private CharacterSkillTotalInformation skill;
}
