package by.bsuir.dc.post;

import by.bsuir.dc.news.News;
import jakarta.persistence.*;
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
    private String content;

    @JoinColumn(name = "news_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private News news;
}
