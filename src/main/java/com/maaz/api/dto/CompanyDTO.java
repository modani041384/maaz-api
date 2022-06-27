package com.maaz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class CompanyDTO implements Serializable {
    private Long id;
    private String companyId;//uuid
    private String toolName;
    private String welcomeTitle;
    private String welcomeText;
    private String introduceTitle;
    private String introduceText;
    private String opportunity1Title;
    private String opportunity1Text;
    private String opportunity2Title;
    private String opportunity2Text;
    private String address;
    private String tel;
    private String email;
    private String linkFb;
    private String linkIns;
    private String linkYouTube;

    //end
}
