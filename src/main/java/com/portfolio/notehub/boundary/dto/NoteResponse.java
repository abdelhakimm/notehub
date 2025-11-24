package com.portfolio.notehub.boundary.dto;

import java.time.Instant;

public record NoteResponse(
        Long id,
        String title,
        String content,
        Instant createdAt
) {}
