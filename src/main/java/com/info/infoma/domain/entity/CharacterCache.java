package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.CharacterTotalInformation;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash(value = "info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterCache {
    @Id
    @Column(name = "char_name")
    private String characterName;

    private LocalDateTime createdAt;

    private CharacterTotalInformation info;

    @Builder
    public CharacterCache(String characterName, LocalDateTime createdAt, CharacterTotalInformation info) {
        this.characterName = characterName;
        this.createdAt = createdAt;
        this.info = info;
    }
}
