package com.info.infoma.domain.entity;

import com.info.infoma.domain.dto.CharacterLevelDto;
import com.info.infoma.domain.entity.common.CommonAudit;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "character_level"
    , uniqueConstraints = {
        @UniqueConstraint(name="character_level_unique", columnNames = {"char_id", "level_date"})
    }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterLevel extends CommonAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "char_id")
    private Character character;

    @Column(name = "level")
    private int level;

    @Column(name = "exp_rate")
    private String expRate;

    @Column(name = "level_date")
    private LocalDate levelDate;

    @Builder
    public CharacterLevel(Long id, Character character, int level, String expRate, LocalDate levelDate) {
        this.id = id;
        this.character = character;
        this.level = level;
        this.expRate = expRate;
        this.levelDate = levelDate;
    }

    public CharacterLevelDto toDto() {
        return new CharacterLevelDto(this.level, this.expRate, this.levelDate.format(DateTimeFormatter.ofPattern("yy-MM-dd")));
    }
}
