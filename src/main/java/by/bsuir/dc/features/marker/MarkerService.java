package by.bsuir.dc.features.marker;

import by.bsuir.dc.exceptions.EntityNotFoundException;
import by.bsuir.dc.features.marker.dto.MarkerRequestDto;
import by.bsuir.dc.features.marker.dto.MarkerResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MarkerService {
    private final MarkerRepository markerRepository;

    private final MarkerMapper markerMapper;

    public MarkerResponseDto addMarker(MarkerRequestDto markerRequestDto) {
        var marker = markerMapper.toEntity(markerRequestDto);
        marker = markerRepository.save(marker);
        return markerMapper.toDto(marker);
    }

    public List<MarkerResponseDto> getAllMarkers() {
        var markers = markerRepository.findAll();
        return markerMapper.toDtoList(markers);
    }

    public MarkerResponseDto getById(Long markerId) {
        var marker = markerRepository.findById(markerId).orElseThrow(
                () -> new EntityNotFoundException("")
        );
        return markerMapper.toDto(marker);
    }

    public MarkerResponseDto updateById(Long markerId, MarkerRequestDto markerRequestDto) {
        var doesExist = markerRepository.existsById(markerId);
        if (doesExist) {
            throw new EntityNotFoundException("");
        }

        var marker = markerMapper.toEntity(markerRequestDto);
        marker.setId(markerId);
        markerRepository.save(marker);

        return markerMapper.toDto(marker);
    }

    public void deleteById(Long markerId) {
        var doesExist = markerRepository.existsById(markerId);
        if (doesExist) {
            throw new EntityNotFoundException("");
        }

        markerRepository.deleteById(markerId);
    }
}
