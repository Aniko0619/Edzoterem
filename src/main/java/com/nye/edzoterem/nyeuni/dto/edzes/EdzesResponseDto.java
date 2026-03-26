package com.nye.edzoterem.nyeuni.dto.edzes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EdzesResponseDto {

    private Long id;
    private String name;
    private String edzoName;

}
