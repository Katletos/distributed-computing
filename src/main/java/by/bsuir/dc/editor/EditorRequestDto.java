package by.bsuir.dc.editor;

import java.io.Serializable;

/**
 * DTO for {@link Editor}
 */
public record EditorRequestDto(String login, String password, String firstName,
                               String lastName) implements Serializable {
}