package by.bsuir.dc.features.post;

import by.bsuir.dc.exceptions.EntityNotFoundException;
import by.bsuir.dc.features.news.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    private final NewsRepository newsRepository;

    private final PostMapper postMapper;

    public PostReponseDto addPost(PostRequestDto postRequestDto) {
        boolean doesExist = newsRepository.existsById(postRequestDto.newsId());
        if (doesExist) {
            throw new EntityNotFoundException("News does not exist");
        }

        var post = postMapper.toEntity(postRequestDto);
        post = postRepository.save(post);

        return postMapper.toDto(post);
    }

    public List<PostReponseDto> getAll() {
        var posts = postRepository.findAll();
        return postMapper.toDtoList(posts);
    }

    public PostReponseDto getById(Long postId) {
        var post = postRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("")
        );
        return postMapper.toDto(post);
    }

    public PostReponseDto update(Long postId, PostRequestDto postRequestDto) {
        var doesExist = postRepository.existsById(postId);
        if (doesExist) {
            throw new EntityNotFoundException("");
        }

        var post = postMapper.toEntity(postRequestDto);
        post.setId(postId);
        postRepository.save(post);

        return postMapper.toDto(post);
    }

    public void deleteById(Long postId) {
        var doesExists = postRepository.existsById(postId);
        if (doesExists) {
            throw new EntityNotFoundException("");
        }

        postRepository.deleteById(postId);
    }
}
