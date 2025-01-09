package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoDTO {
    @NotBlank(message = "Title cannot be empty")
    private String title;
    private boolean completed;
}
