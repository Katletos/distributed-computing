package by.bsuir.dc.features.editor.dto;

import by.bsuir.dc.features.editor.Editor;

import java.io.Serializable;

/**
 * DTO for {@link Editor}
 */
public record CreateEditorDto(String login, String password, String firstName,
                              String lastName) implements Serializable {
}