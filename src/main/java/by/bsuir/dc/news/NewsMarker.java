package by.bsuir.dc.news;

import by.bsuir.dc.marker.Marker;
import by.bsuir.dc.news.News;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "news_marker")
public class NewsMarker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "news_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<News> news = new ArrayList<>();

    @JoinColumn(name = "marked_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Marker> marker = new ArrayList<>();
}
