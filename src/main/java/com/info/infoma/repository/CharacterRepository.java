package com.info.infoma.repository;

import com.info.infoma.domain.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    @Query("select c from Character c where c.characterName = :characterName")
    Optional<Character> findByCharacterName(String characterName) throws Exception;
}
