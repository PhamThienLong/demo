package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.ProviderWrapper;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "provider")
@Data
public class Provider implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Integer id;
    @Column(name = "provider_name")
    private String name;
    private String address;
    private String phone;

    public Provider() {
    }

    public Provider(ProviderWrapper pro) {
        this.id = pro.getId();
        this.name = pro.getName();
        this.address = pro.getAddress();
        this.phone = pro.getPhone();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
