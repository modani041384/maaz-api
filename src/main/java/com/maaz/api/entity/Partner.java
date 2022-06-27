package com.maaz.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "partner_info")
@Data
public class Partner extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "partner_id")
    private String partnerId;//uuid

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private Blob logo;

    @Column(name = "short_story")
    private String shortStory;

    @Column(name = "story")
    private Blob story;

    @Column(name = "link")
    private String link;

    //end
}
