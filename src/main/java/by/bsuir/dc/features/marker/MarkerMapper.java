package by.bsuir.dc.features.marker;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkerMapper {
    MarkerResponseDto toDto(Marker marker);

    List<MarkerResponseDto> toDtoList(List<Marker> markers);
    Marker toEntity(MarkerRequestDto markerRequestDto);
}
