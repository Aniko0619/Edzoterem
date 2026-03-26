package com.nye.edzoterem.nyeuni.service;

import com.nye.edzoterem.nyeuni.dto.edzes.EdzesRequestDto;
import com.nye.edzoterem.nyeuni.dto.edzes.EdzesResponseDto;
import com.nye.edzoterem.nyeuni.entity.Edzes;
import com.nye.edzoterem.nyeuni.repository.EdzesRepository;
import org.springframework.stereotype.Service;

@Service
public class EdzesService {

    private final EdzesRepository edzesRepository;

    public EdzesService(EdzesRepository edzesRepository) {
        this.edzesRepository = edzesRepository;
    }

    public EdzesResponseDto createEdzes(EdzesRequestDto edzesRequestDto){
       Edzes edzes = Edzes.builder()
               .name(edzesRequestDto.getName())
               .edzoName(edzesRequestDto.getEdzoName())
               .build();
       Edzes saveEdzes = edzesRepository.save(edzes);
       return mapToDto(saveEdzes);
   }


   // itt kérjük el az adatbázisból az összes 'edzest'
   private EdzesResponseDto mapToDto(Edzes edzes){

        return EdzesResponseDto.builder()
                .id(edzes.getId())
                .name(edzes.getName())
                .edzoName(edzes.getEdzoName())
                .build();
   }
}
