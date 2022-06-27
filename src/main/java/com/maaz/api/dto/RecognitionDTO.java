package com.maaz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class RecognitionDTO implements Serializable {
    private Long id;
    private String recognitionsId;//uuid
    private String name;
    private String pic;
    private String link;

    //end
}
