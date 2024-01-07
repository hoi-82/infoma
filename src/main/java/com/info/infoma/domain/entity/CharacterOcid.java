package com.info.infoma.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CHAR_OCID")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterOcid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ocid_id")
    private Long id;

    @Column(name = "char_name")
    private String characterName;

    @Column(name = "char_ocid")
    private String characterOcid;

    @Builder
    public CharacterOcid(Long id, String characterName, String characterOcid) {
        this.id = id;
        this.characterName = characterName;
        this.characterOcid = characterOcid;
    }
}
