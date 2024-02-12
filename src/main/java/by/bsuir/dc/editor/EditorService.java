package by.bsuir.dc.editor;

import by.bsuir.dc.EntityAlreadyExistsException;
import by.bsuir.dc.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EditorService {
    private final EditorRepository editorRepository;

    private final EditorMapper editorMapper;

    public EditorResponseDto getById(Long editorId) {
        Editor editor = editorRepository.findById(editorId)
                .orElseThrow(() -> new EntityNotFoundException("s"));
        return editorMapper.toDto(editor);
    }

    public EditorResponseDto addEditor(EditorRequestDto editorRequestDto) throws EntityAlreadyExistsException {
        Editor editor = editorMapper.toEntity(editorRequestDto);

        boolean doesExist = editorRepository.existsByLogin(editor.getLogin());
        if (doesExist) {
            throw new EntityAlreadyExistsException("s");
        }

        editorRepository.save(editor);
        return editorMapper.toDto(editor);
    }

    public EditorResponseDto deleteById(Long editorId) {
        return new EditorResponseDto("asd","asd","asd");
    }
}
