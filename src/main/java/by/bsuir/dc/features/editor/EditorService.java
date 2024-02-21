package by.bsuir.dc.features.editor;

import by.bsuir.dc.exceptions.BusinessRuleException;
import by.bsuir.dc.exceptions.EntityAlreadyExistsException;
import by.bsuir.dc.exceptions.EntityNotFoundException;
import by.bsuir.dc.features.editor.dto.CreateEditorDto;
import by.bsuir.dc.features.editor.dto.EditorResponseDto;
import by.bsuir.dc.features.news.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorService {
    private final EditorRepository editorRepository;
    private final EditorMapper editorMapper;
    private final NewsRepository newsRepository;

    public List<EditorResponseDto> getAllEditors() {
        var editors = editorRepository.findAll();
        return editorMapper.toDtoList(editors);
    }

    public EditorResponseDto getById(Long editorId) {
        var editor = editorRepository.findById(editorId)
                .orElseThrow(() -> new EntityNotFoundException("Editor with such id not found"));
        return editorMapper.toDto(editor);
    }

    public EditorResponseDto addEditor(CreateEditorDto createEditorDto) throws EntityAlreadyExistsException {
        var editor = editorMapper.toEntity(createEditorDto);

        var doesExist = editorRepository.existsByLogin(editor.getLogin());
        if (doesExist) {
            throw new EntityAlreadyExistsException("Editor with such login already exist");
        }

        editorRepository.save(editor);
        return editorMapper.toDto(editor);
    }

    public EditorResponseDto deleteById(Long editorId) {
        var doesNewsExists = newsRepository.existsByEditorId(editorId);
        if (doesNewsExists) {
            throw new BusinessRuleException("Delete news before editor");
        }

        var editor = editorRepository.findById(editorId).orElseThrow(
                () -> new EntityNotFoundException("Editor with such id is not exists"));

        editorRepository.deleteById(editorId);
        return editorMapper.toDto(editor);
    }

    public EditorResponseDto updateById(Long editorId, CreateEditorDto createEditorDto) {
        var editor = editorMapper.toEntity(createEditorDto);
        editor.setId(editorId);

        editor = editorRepository.save(editor);

        return editorMapper.toDto(editor);
    }

    public EditorResponseDto getByNewsId(Long newsId) {
        var doesExists = newsRepository.existsById(newsId);
        if (!doesExists){
            throw new EntityNotFoundException("New with such id does not exists");
        }

        var editor = editorRepository.findByNewsId(newsId).orElseThrow(
                () -> new EntityNotFoundException("News does not have editor"));

        return editorMapper.toDto(editor);
    }
}
