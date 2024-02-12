package by.bsuir.dc.marker;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marker")
@Getter
@Setter
@RequiredArgsConstructor
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}
