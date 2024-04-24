package com.info.infoma.domain.vo;

import com.info.infoma.domain.dto.character.CharacterDojang;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class DojangRecord {
    private int dojangBestFloor;
    private String dateDojangRecord;
    private String dojangBestTime;

    public static DojangRecord toDojangRecord(CharacterDojang characterDojang) {
        return DojangRecord.builder()
                .dojangBestFloor(characterDojang.dojangBestFloor())
                .dateDojangRecord(characterDojang.dateDojangRecord() == null ? "" : characterDojang.dateDojangRecord().split("T")[0])
                .dojangBestTime((characterDojang.dojangBestTime() / 60) + "분 " + (characterDojang.dojangBestTime() % 60) + "초")
                .build();
    }
}