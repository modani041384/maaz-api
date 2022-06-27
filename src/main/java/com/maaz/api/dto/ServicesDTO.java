package com.maaz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class ServicesDTO implements Serializable {
    private Long id;
    private String serviceId;//uuid
    private Integer type;
    private String typeName;
    private String description;

    //end
}
