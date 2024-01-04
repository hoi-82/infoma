package com.info.infoma.configuration;

import com.info.infoma.domain.vo.MapleApiServiceKey;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class MapleStoryApiConfig {

    private final MapleApiServiceKey serviceKey;

    @Bean
    public RequestInterceptor requestInterceptor() throws InterruptedException {
        log.debug("TEST : {}", serviceKey == null ? "null" : serviceKey.getKey());
        return requestTemplate -> requestTemplate.header("x-nxopen-api-key", serviceKey.getKey());
    }
}
