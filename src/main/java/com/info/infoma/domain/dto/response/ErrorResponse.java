package com.info.infoma.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

public record ErrorResponse(boolean status, String message) {
    @Builder
    public ErrorResponse {
    }
}
