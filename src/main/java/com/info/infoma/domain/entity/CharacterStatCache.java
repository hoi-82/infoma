package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.response.CharacterStatTotalInformation;
import com.info.infoma.domain.entity.common.CharacterCommonCache;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "character_stat")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterStatCache extends CharacterCommonCache {
    @Id
    @Column(name = "char_name")
    private String characterName;

    private CharacterStatTotalInformation stat;
}
