package by.bsuir.dc.features.post;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
public record PostReponseDto(String content, Long newsId) implements Serializable {
}