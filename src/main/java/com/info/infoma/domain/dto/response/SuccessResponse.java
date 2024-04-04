package com.info.infoma.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

public record SuccessResponse<T>(boolean status, String message, T data) {
    @Builder
    public SuccessResponse {
    }
}
