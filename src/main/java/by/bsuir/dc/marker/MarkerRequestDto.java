package by.bsuir.dc.marker;

import java.io.Serializable;

/**
 * DTO for {@link Marker}
 */
public record MarkerRequestDto(String name) implements Serializable {
}