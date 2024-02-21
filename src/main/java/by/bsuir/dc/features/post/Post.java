package by.bsuir.dc.features.post;

import by.bsuir.dc.features.news.News;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "post")
@Getter
@Setter
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content")
    @Size(min = 2, max = 2048)
    private String content;

    @JoinColumn(name = "news_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private News news;
}
