package com.info.infoma.configuration;

import com.info.infoma.domain.vo.MapleApiServiceKey;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

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

    @Bean
    public FeignFormatterRegistrar localDateFeignFormatterRegister() {
        return registry -> {
            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
            registrar.setUseIsoFormat(true);
            registrar.registerFormatters(registry);
        };
    }

}
