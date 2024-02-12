package by.bsuir.dc.post;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
public record PostRequestDto(String content, Long newsId) implements Serializable {
}