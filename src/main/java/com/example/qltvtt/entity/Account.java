package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.AccountWrapper;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String Phone;
    private String Position;

    public Account() {

    }

    public Account(AccountWrapper acw) {
        this.Id = acw.getId();
        this.Name = acw.getName();
        this.Phone = acw.getPhone();
        this.Position = acw.getPosition();
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public Account(String name, String phone) {
        this.Name = name;
        this.Phone = phone;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }
}