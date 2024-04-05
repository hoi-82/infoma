package com.info.infoma.domain.entity.common;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public class CharacterCommonCache {
//    private String dataTime;

    @CreatedDate
    private LocalDateTime createdAt;

    // 데이터 날짜 확인
//    public boolean isYesterday(String time) {
//        return dataTime.equals(time);
//    }
}
