package com.maaz.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "news_info")
@Data
public class News extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "news_id")
    private String newsId;//uuid

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private Integer type;

    @Column(name = "url")
    private String url;

    @Column(name = "content")
    private Blob content;

    @Column(name = "tab1")
    private String tab1;

    @Column(name = "tab2")
    private String tab2;

    @Column(name = "tab3")
    private String tab3;

    @Column(name = "tab4")
    private String tab4;

    @Column(name = "view")
    private Integer view;

    //end
}
