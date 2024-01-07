package com.info.infoma.repository;

import com.info.infoma.domain.entity.CharacterOcid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CharacterOcidRepository extends JpaRepository<CharacterOcid, Long> {
    @Query("select c from CharacterOcid c where c.characterName = :characterName")
    Optional<CharacterOcid> findByCharName(String characterName) throws Exception;
}
