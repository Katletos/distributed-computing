package by.bsuir.dc.editor;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditorMapper {
    EditorResponseDto toDto(Editor editor);
    Editor toEntity(EditorRequestDto editorResponseDto);
}
