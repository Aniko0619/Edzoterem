package com.nye.edzoterem.nyeuni.dto.tag;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagResponseDto {
    private Long tagId;           // volt: id
    private String tagNeve;       // volt: name
    private Integer kor;          // volt: age
    private Long edzesId;         // marad
    private String edzesprogramNeve;  // volt: edzesName
}