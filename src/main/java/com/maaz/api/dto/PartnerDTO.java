package com.maaz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class PartnerDTO implements Serializable {
    private Long id;
    private String partnerId;//uuid
    private String name;
    private String logo;
    private String shortStory;
    private String story;
    private String link;

    //end
}
