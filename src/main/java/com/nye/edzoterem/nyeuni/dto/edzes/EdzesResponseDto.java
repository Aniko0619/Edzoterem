package com.nye.edzoterem.nyeuni.dto.edzes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EdzesResponseDto {
    private Long edzesId;              // volt: id
    private String edzesprogramNeve;   // volt: name
    private String edzoNeve;           // volt: edzoName
}