package by.bsuir.dc.news;

import by.bsuir.dc.editor.Editor;
import by.bsuir.dc.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @OneToMany(mappedBy = "news", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @JoinColumn(name = "editor_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Editor editor;
}
