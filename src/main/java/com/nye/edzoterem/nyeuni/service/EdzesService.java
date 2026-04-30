package com.nye.edzoterem.nyeuni.service;

import java.util.List;
import java.util.Optional;
import com.nye.edzoterem.nyeuni.dto.edzes.EdzesRequestDto;
import com.nye.edzoterem.nyeuni.dto.edzes.EdzesResponseDto;
import com.nye.edzoterem.nyeuni.entity.Edzes;
import com.nye.edzoterem.nyeuni.entity.exception.ResourceNotFoundException;
import com.nye.edzoterem.nyeuni.repository.EdzesRepository;
import org.springframework.stereotype.Service;

@Service
public class EdzesService {

    private final EdzesRepository edzesRepository;

    public EdzesService(EdzesRepository edzesRepository) {
        this.edzesRepository = edzesRepository;
    }

    public EdzesResponseDto createEdzes(EdzesRequestDto edzesRequestDto) {
        Edzes edzes = Edzes.builder()
                .name(edzesRequestDto.getName())
                .edzoName(edzesRequestDto.getEdzoName())
                .build();
        Edzes savedEdzes = edzesRepository.save(edzes);
        return mapToDto(savedEdzes);
    }

    public List<EdzesResponseDto> getAllEdzesek() {        // Javítva: metódusnév konzisztens a controllerrel
        return edzesRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public EdzesResponseDto getEdzesById(Long id) {
        Edzes edzes = edzesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Edzes not found by id: " + id));
        return mapToDto(edzes);
    }

    public EdzesResponseDto updateEdzes(Long id, EdzesRequestDto requestDto) {
        Edzes edzes = edzesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Edzes not found by id: " + id));

        edzes.setName(requestDto.getName());
        edzes.setEdzoName(requestDto.getEdzoName());

        Edzes updatedEdzes = edzesRepository.save(edzes);
        return mapToDto(updatedEdzes);
    }

    public void deleteEdzes(Long id) {
        edzesRepository.deleteById(id);
    }

    private EdzesResponseDto mapToDto(Edzes edzes) {
        return EdzesResponseDto.builder()
                .id(edzes.getId())
                .name(edzes.getName())
                .edzoName(edzes.getEdzoName())
                .build();
    }
}

