package com.maaz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class NewsDTO implements Serializable {
    private Long id;
    private String newsId;//uuid
    private String title;
    private Integer type;
    private String url;
    private String content;
    private String tab1;
    private String tab2;
    private String tab3;
    private String tab4;
    private Integer view;

    //end
}
