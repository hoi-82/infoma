package com.info.infoma.service;

import com.info.infoma.domain.dto.CharacterLevelDto;
import com.info.infoma.domain.dto.character.CharacterBasicInformation;
import com.info.infoma.domain.entity.Character;
import com.info.infoma.domain.entity.CharacterLevel;
import com.info.infoma.openfeign.CharacterInformationClient;
import com.info.infoma.repository.CharacterLevelRepository;
import com.info.infoma.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharacterStatisticsService {
    private final CharacterRepository characterRepository;
    private final CharacterLevelRepository levelRepository;
    private final CharacterInformationClient characterInformationClient;

    @Transactional
    public List<CharacterLevelDto> findCharacterLevelAndExpNear5Days(String characterName) throws Exception {

        Character character = characterRepository.findByCharacterName(characterName).orElseThrow();

        if(character.getCharacterOcid().isEmpty()) character.changeOcid(characterInformationClient.getUserOcid(characterName).ocid());

        LocalDate near5DayDate = LocalDate.now().minusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<CharacterLevel> levels = levelRepository.findAllByCharacterAndLevelDateGreaterThanEqualOrderByLevelDateAsc(character, near5DayDate);

        for(int i=0; i<5; i++) {
            int index = i;
            if(levels.isEmpty() || levels.stream().noneMatch(level -> level.getLevelDate().isEqual(near5DayDate.plusDays(index)))) {
                CharacterBasicInformation characterBasicInformationByDate = characterInformationClient.getCharacterBasicInformationByDate(
                        character.getCharacterOcid(), near5DayDate.plusDays(index).format(formatter));

                CharacterLevel level = CharacterLevel.builder()
                        .character(character)
                        .level(characterBasicInformationByDate.characterLevel())
                        .expRate(characterBasicInformationByDate.characterExpRate())
                        .levelDate(near5DayDate.plusDays(index))
                        .build();

                levels.add(level);

                levelRepository.save(level);
            }
        }

        return levels.stream().map(CharacterLevel::toDto).toList();
    }
}
