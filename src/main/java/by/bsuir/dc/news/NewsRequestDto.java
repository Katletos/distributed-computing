package by.bsuir.dc.news;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link News}
 */
public record NewsRequestDto(Long id, String title, String content, Instant created, Instant modified,
                             Long editorId) implements Serializable {
}