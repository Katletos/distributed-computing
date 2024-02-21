package by.bsuir.dc.features.news;

import by.bsuir.dc.features.editor.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    boolean existsByEditorId(Long editorId);

    boolean existsById(Long newsId);
}