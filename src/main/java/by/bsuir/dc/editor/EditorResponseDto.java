package by.bsuir.dc.editor;

import java.io.Serializable;

/**
 * DTO for {@link Editor}
 */
public record EditorResponseDto(String login, String firstName, String lastName) implements Serializable {
}