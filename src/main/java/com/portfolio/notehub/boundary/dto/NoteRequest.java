package com.portfolio.notehub.boundary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NoteRequest(

        @NotBlank(message = "Title cannot be empty")
        @Size(max = 200, message = "Title cannot exceed 200 characters")
        String title,

        @Size(max = 10_000, message = "Content is too long")
        String content
) {}
