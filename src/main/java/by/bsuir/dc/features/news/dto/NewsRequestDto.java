package by.bsuir.dc.features.news.dto;

import by.bsuir.dc.features.news.News;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link News}
 */
public record NewsRequestDto(String title, String content, Instant created, Instant modified,
                             Long editorId) implements Serializable {
}