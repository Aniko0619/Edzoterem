
package com.nye.edzoterem.nyeuni.dto.tag;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TagResponseDto {

    private Long id;
    private String name;
    private Integer age;
    private Long edzesId;
    private String edzesName;
}
