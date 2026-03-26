package com.nye.edzoterem.nyeuni.dto.edzes;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EdzesRequestDto {

    @NotBlank(message = "Edzes name is requed!")
    private String name;
    private String edzoName;

}
