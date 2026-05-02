package com.nye.edzoterem.nyeuni.dto.edzes;

import com.nye.edzoterem.nyeuni.entity.Tag;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class EdzesResponseDto {
    private Long edzesId;
    private String edzesprogramNeve;
    private String edzoNeve;
    private List<Tag> tagok;
}