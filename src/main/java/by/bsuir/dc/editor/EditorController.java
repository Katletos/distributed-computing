package by.bsuir.dc.editor;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/editors")
@RequiredArgsConstructor
public class EditorController {
    private final EditorService editorService;

    @GetMapping("/{editorId}")
    public ResponseEntity<EditorResponseDto> getById(
            @PathVariable Long editorId
    ){
        var editor = editorService.getById(editorId);
        return ResponseEntity.ok(editor);
    }

    @DeleteMapping("/{editorId}")
    public EditorResponseDto deleteById(
            @PathVariable Long editorId
    ){
        return editorService.deleteById(editorId);
    }
}
