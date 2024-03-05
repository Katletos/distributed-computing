package by.bsuir.dc.features.post;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostReponseDto toDto(Post post);

    List<PostReponseDto> toDtoList(List<Post> posts);

    Post toEntity(PostRequestDto postRequestDto);
}
