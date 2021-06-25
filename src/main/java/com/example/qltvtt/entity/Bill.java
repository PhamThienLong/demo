package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.BillWrapper;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bill")
@Data
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    public Integer id;
    @Column(name = "employee_id")
    private Integer emp;
    @Column(name = "user_id")
    private Integer use;
    private String date;

    public Bill() {
    }

    public Bill(BillWrapper biw) {
        this.id = biw.getId();
        this.emp = biw.getEmp();
        this.use = biw.getUse();
        this.date = biw.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmp() {
        return emp;
    }

    public void setEmp(Integer emp) {
        this.emp = emp;
    }

    public Integer getUse() {
        return use;
    }

    public void setUse(Integer use) {
        this.use = use;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
