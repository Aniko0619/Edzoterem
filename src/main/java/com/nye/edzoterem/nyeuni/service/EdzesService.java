package com.nye.edzoterem.nyeuni.service;

import java.util.List;
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
                .edzesprogramNeve(edzesRequestDto.getEdzesprogramNeve())
                .edzoNeve(edzesRequestDto.getEdzoNeve())
                .build();
        Edzes savedEdzes = edzesRepository.save(edzes);
        return mapToDto(savedEdzes);
    }

    public List<EdzesResponseDto> getAllEdzesek() {
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

        edzes.setEdzesprogramNeve(requestDto.getEdzesprogramNeve());
        edzes.setEdzoNeve(requestDto.getEdzoNeve());

        Edzes updatedEdzes = edzesRepository.save(edzes);
        return mapToDto(updatedEdzes);
    }

    public void deleteEdzes(Long id) {
        if (!edzesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Edzes not found by id: " + id);
        }
        edzesRepository.deleteById(id);
    }

    private EdzesResponseDto mapToDto(Edzes edzes) {
        return EdzesResponseDto.builder()
                .edzesId(edzes.getEdzesId())
                .edzesprogramNeve(edzes.getEdzesprogramNeve())
                .edzoNeve(edzes.getEdzoNeve())
                .build();
    }
}