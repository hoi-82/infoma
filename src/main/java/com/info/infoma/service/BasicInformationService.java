package com.info.infoma.service;

import com.info.infoma.domain.vo.MapleApiServiceKey;
import com.info.infoma.openfeign.CharacterInformationClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasicInformationService {

    private final CharacterInformationClient characterInformationClient;

//    private MapleApiServiceKey serviceKey;

    public String getOcid(String characterName) throws Exception {
        log.debug("[getOcid] CharacterName : {}", characterName);
        return characterInformationClient.getUserOcid(characterName).ocid();
//        return serviceKey.getKey();
    };
}
