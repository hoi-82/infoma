package com.info.infoma.domain.entity;

import com.info.infoma.domain.entity.common.CommonAudit;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "character_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character extends CommonAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "char_id")
    private Long id;

    @Column(name = "char_name")
    private String characterName;

    @Column(name = "char_ocid")
    private String characterOcid;

    @OneToMany(mappedBy = "character")
    private List<CharacterLevel> levels;

    @Builder
    public Character(Long id, String characterName, String characterOcid, List<CharacterLevel> levels) {
        this.id = id;
        this.characterName = characterName;
        this.characterOcid = characterOcid;
        this.levels = levels;
    }

    public void changeOcid(String newOcid) {
        this.characterOcid = newOcid;
    }
}
