package com.info.infoma.openfeign;

import com.info.infoma.configuration.MapleStoryApiConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "UnionInformationClient", url = "${maple-api.host}", configuration = MapleStoryApiConfig.class)
public interface UnionInformationClient {
}
