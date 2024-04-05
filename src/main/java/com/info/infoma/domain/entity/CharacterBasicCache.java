package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.response.CharacterBasicTotalInformation;
import com.info.infoma.domain.entity.common.CharacterCommonCache;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "character_basic")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterBasicCache extends CharacterCommonCache {
    @Id
    @Column(name = "char_name")
    private String characterName;

    private CharacterBasicTotalInformation basic;

}
