package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.response.CharacterStatTotalInformation;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash(value = "character_stat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterStatCache {
    @Id
    @Column(name = "char_name")
    private String characterName;

    @CreatedDate
    private LocalDateTime createdAt;

    private String dataTime;

    private CharacterStatTotalInformation basic;

    @Builder
    public CharacterStatCache(String characterName, LocalDateTime createdAt, String dataTime, CharacterStatTotalInformation basic) {
        this.characterName = characterName;
        this.createdAt = createdAt;
        this.basic = basic;
        this.dataTime = dataTime;
    }
}
