package com.nye.edzoterem.nyeuni.dto.tag;

import jakarta.validation.constraints.NotBlank;

public class TagRequestDto {

    @NotBlank(message = "Tag name is required!")               // ha Null lenne, üzenet
    private String name;
    private Integer age;
    private Long edzesId;

}
