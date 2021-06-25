package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.ProviderWrapper;
import com.example.qltvtt.entitywrapper.PublisherWrapper;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "publisher")
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer id;
    @Column(name = "publisher_name")
    private String name;
    private String address;
    private String email;

    public Publisher() {
    }

    public Publisher(PublisherWrapper pub) {
        this.id = pub.getId();
        this.name = pub.getName();
        this.address = pub.getAddress();
        this.email = pub.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
