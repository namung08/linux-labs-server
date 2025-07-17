package com.exam.linuxlabs.dto;

import com.exam.linuxlabs.model.Lang;
import lombok.Builder;

@Builder
public record GreetingResponse(
    Lang lang,
    String message
) {
}
