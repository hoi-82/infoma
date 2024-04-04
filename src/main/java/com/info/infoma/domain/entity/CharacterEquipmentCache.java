package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.response.CharacterEquipmentTotalInformation;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash(value = "character_equipment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterEquipmentCache {
    @Id
    @Column(name = "char_name")
    private String characterName;

    @CreatedDate
    private LocalDateTime createdAt;

    private String dataTime;

    private CharacterEquipmentTotalInformation basic;

    @Builder
    public CharacterEquipmentCache(String characterName, LocalDateTime createdAt, String dataTime, CharacterEquipmentTotalInformation basic) {
        this.characterName = characterName;
        this.createdAt = createdAt;
        this.basic = basic;
        this.dataTime = dataTime;
    }
}
