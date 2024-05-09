package com.info.infoma.repository;

import com.info.infoma.domain.entity.Character;
import com.info.infoma.domain.entity.CharacterLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CharacterLevelRepository extends JpaRepository<CharacterLevel, Long> {
    List<CharacterLevel> findAllByCharacterAndLevelDateGreaterThanEqualOrderByLevelDateAsc(Character character, LocalDate near5DayDate);
}
