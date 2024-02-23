package com.info.infoma.domain.vo;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
@AllArgsConstructor
@ConfigurationProperties(prefix = "maple-api")
public class MapleApiServiceKey {
    @NotEmpty
    private final String key;
}
