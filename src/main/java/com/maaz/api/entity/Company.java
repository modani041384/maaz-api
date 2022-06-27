package com.maaz.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company_info")
@Data
public class Company extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_id")
    private String companyId;//uuid

    @Column(name = "tool_name")
    private String toolName;

    @Column(name = "welcome_title")
    private String welcomeTitle;

    @Column(name = "welcome_text")
    private String welcomeText;

    @Column(name = "introduce_title")
    private String introduceTitle;

    @Column(name = "introduce_text")
    private String introduceText;

    @Column(name = "opportunity1_title")
    private String opportunity1Title;

    @Column(name = "opportunity1_text")
    private String opportunity1Text;

    @Column(name = "opportunity2_title")
    private String opportunity2Title;

    @Column(name = "opportunity2_text")
    private String opportunity2Text;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "link_fb")
    private String linkFb;

    @Column(name = "link_ins")
    private String linkIns;

    @Column(name = "link_youtube")
    private String linkYouTube;

    //end
}
