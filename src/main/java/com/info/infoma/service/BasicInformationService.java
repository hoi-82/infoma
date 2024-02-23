package com.info.infoma.service;

import com.info.infoma.domain.dto.*;
import com.info.infoma.domain.entity.CharacterCache;
import com.info.infoma.domain.entity.CharacterOcid;
import com.info.infoma.openfeign.CharacterInformationClient;
import com.info.infoma.repository.CharacterInfoCacheRepository;
import com.info.infoma.repository.CharacterOcidRepository;
import com.info.infoma.util.MapleApiRowDataRefactor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class BasicInformationService {

    private final CharacterInformationClient characterInformationClient;
    private final CharacterOcidRepository characterOcidRepository;
    private final CharacterInfoCacheRepository characterInfoCacheRepository;

    @Transactional
    public CharacterTotalInformation getCharacterInformation(String characterName) throws Exception {
        log.info("CharacterName : {}", characterName);

        String characterOcid = null;
        String formattedYesterDay = LocalDate.now().minusDays(1)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Optional<CharacterOcid> ocidEntity = characterOcidRepository.findByCharName(characterName);

        if(ocidEntity.isPresent()) characterOcid = ocidEntity.orElseThrow().getCharacterOcid();
        else {
            try {
                characterOcid = characterInformationClient.getUserOcid(characterName).ocid();
            }catch(Exception ignored) {
                throw new Exception();
            }

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
        CharacterSymbolEquipment symbolEquipment = null;

        try{
            basicInfo = characterInformationClient.getCharacterBasicInformation(characterOcid, formattedYesterDay);
            symbolEquipment = characterInformationClient.getCharacterSymbolEquipment(characterOcid, formattedYesterDay);
        }catch(Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        symbolEquipment.symbol().forEach(MapleApiRowDataRefactor::symbolRefactor);

        CharacterTotalInformation totalInformation = new CharacterTotalInformation(
                basicInfo, symbolEquipment
        );

        characterInfoCacheRepository.save(
                CharacterCache.builder()
                        .characterName(characterName)
                        .createdAt(LocalDateTime.now())
                        .info(totalInformation)
                        .build()
        );

        return totalInformation;
    }
}
