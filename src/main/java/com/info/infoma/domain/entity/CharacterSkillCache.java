package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.response.CharacterSkillTotalInformation;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash(value = "character_skill")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterSkillCache {
    @Id
    @Column(name = "char_name")
    private String characterName;

    @CreatedDate
    private LocalDateTime createdAt;

    private String dataTime;

    private CharacterSkillTotalInformation basic;

    @Builder
    public CharacterSkillCache(String characterName, LocalDateTime createdAt, String dataTime, CharacterSkillTotalInformation basic) {
        this.characterName = characterName;
        this.createdAt = createdAt;
        this.basic = basic;
        this.dataTime = dataTime;
    }
}
