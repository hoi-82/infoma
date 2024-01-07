package com.info.infoma;

import com.info.infoma.domain.vo.MapleApiServiceKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableConfigurationProperties({MapleApiServiceKey.class})
@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
public class InfomaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfomaApplication.class, args);
	}

}
