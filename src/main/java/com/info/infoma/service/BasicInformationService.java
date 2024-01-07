package com.info.infoma.service;

import com.info.infoma.domain.dto.*;
import com.info.infoma.domain.entity.CharacterOcid;
import com.info.infoma.openfeign.CharacterInformationClient;
import com.info.infoma.repository.CharacterOcidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class BasicInformationService {

    private final CharacterInformationClient characterInformationClient;
    private final CharacterOcidRepository characterOcidRepository;

    @Transactional
    public CharacterTotalInformation getCharacterInformation(String characterName) throws Exception {
        log.info("CharacterName : {}", characterName);

        String characterOcid = null;
        String formattedYesterDay = LocalDate.now().minusDays(1)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Optional<CharacterOcid> ocidEntity = characterOcidRepository.findByCharName(characterName);

        if(ocidEntity.isPresent()) characterOcid = ocidEntity.orElseThrow().getCharacterOcid();
        else {
            characterOcid = characterInformationClient.getUserOcid(characterName).ocid();
            characterOcidRepository.save(CharacterOcid.builder()
                    .characterName(characterName)
                    .characterOcid(characterOcid)
                    .build()
            );
        }

        if(characterOcid.isEmpty()) throw new Exception();

        log.info("CharacterOcid : {}", characterOcid);
        log.info("FormattedYesterDay : {}", formattedYesterDay);

        CharacterBasicInformation basicInfo = null;
        CharacterStat stat = null;
        CharacterHyperStat hyperStat = null;
        CharacterAbility ability = null;
        CharacterPopularity popularity = null;
        CharacterPropensity propensity = null;

        try{
            basicInfo = characterInformationClient.getCharacterBasicInformation(characterOcid, formattedYesterDay);
            stat = characterInformationClient.getCharacterStat(characterOcid, formattedYesterDay);
            hyperStat = characterInformationClient.getCharacterHyperStat(characterOcid, formattedYesterDay);
            ability = characterInformationClient.getCharacterAbility(characterOcid, formattedYesterDay);
            popularity = characterInformationClient.getCharacterPopularity(characterOcid, formattedYesterDay);
            propensity = characterInformationClient.getCharacterPropensity(characterOcid, formattedYesterDay);
        }catch(Exception e) {
            throw new Exception();
        }

        return new CharacterTotalInformation(
                basicInfo, stat, hyperStat, ability, popularity, propensity
        );
    }
    
}
