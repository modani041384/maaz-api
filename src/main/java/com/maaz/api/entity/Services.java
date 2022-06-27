package com.maaz.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "service_info")
@Data
public class Services extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "service_id")
    private String serviceId;//uuid

    @Column(name = "type")
    private Integer type;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private Blob description;

    //end
}
