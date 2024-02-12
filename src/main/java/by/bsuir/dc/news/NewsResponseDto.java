package by.bsuir.dc.news;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link News}
 */
public record NewsResponseDto(String title, String content, Instant created, Instant modified, List<Long> postIds,
                              Long editorId) implements Serializable {
}