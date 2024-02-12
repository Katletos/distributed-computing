package by.bsuir.dc.post;

import by.bsuir.dc.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}