package com.maaz.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "recognitions_info")
@Data
public class Recognitions  extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "recognitions_id")
    private String recognitionsId;//uuid

    @Column(name = "name")
    private String name;

    @Column(name = "pic")
    private Blob pic;

    @Column(name = "link")
    private String link;

    //end
}
