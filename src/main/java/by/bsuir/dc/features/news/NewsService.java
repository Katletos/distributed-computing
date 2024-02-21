package by.bsuir.dc.features.news;


import by.bsuir.dc.exceptions.EntityNotFoundException;
import by.bsuir.dc.features.editor.EditorRepository;
import by.bsuir.dc.features.news.dto.NewsRequestDto;
import by.bsuir.dc.features.news.dto.NewsResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsMapper newsMapper;
    private final EditorRepository editorRepository;
    private final NewsRepository newsRepository;

    public NewsResponseDto createNews(NewsRequestDto newsRequestDto) {
       var doseExist = editorRepository.existsById(newsRequestDto.editorId());
       if (!doseExist){
           throw new EntityNotFoundException("Editor does not exists");
       }

       var news = newsMapper.toEntity(newsRequestDto);
       news = newsRepository.save(news);
       return newsMapper.toDto(news);
    }

    public List<NewsResponseDto> getAll() {
        var news = newsRepository.findAll();
        return newsMapper.toDtoList(news);
    }

    public NewsResponseDto getById(Long newsId) {
        var news = newsRepository.findById(newsId).orElseThrow(
                () -> new EntityNotFoundException("News with such id does not exists"));
        return newsMapper.toDto(news);
    }
}
