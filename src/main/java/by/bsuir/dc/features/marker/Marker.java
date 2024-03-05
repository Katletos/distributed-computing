package by.bsuir.dc.features.marker;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tbl_marker")
@Getter
@Setter
@RequiredArgsConstructor
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @Size(min = 2, max = 32)
    private String name;
}
