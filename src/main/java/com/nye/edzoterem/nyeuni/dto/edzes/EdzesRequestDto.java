package com.nye.edzoterem.nyeuni.dto.edzes;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EdzesRequestDto {
    @NotBlank(message = "Edzesprogram neve required!")
    private String edzesprogramNeve;   // volt: name
    private String edzoNeve;            // volt: edzoName
}