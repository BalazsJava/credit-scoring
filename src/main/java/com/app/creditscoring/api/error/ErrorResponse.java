package com.app.creditscoring.api.error;

import java.util.List;

public record ErrorResponse(List<String> messages) {

    public ErrorResponse(String message) {
        this(List.of(message));
    }

}