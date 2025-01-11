package com.yakuperenermurat.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoCreateDTO {
    @NotBlank(message = "Title cannot be empty")
    private String title;
}
