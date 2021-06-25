package com.example.qltvtt.entity;
import com.example.qltvtt.entitywrapper.EmployeeWrapper;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;
    @Column(name = "employee_name")
    private String name;
    private String birthday;
    private String phone;

    public Employee() {
    }

    public Employee(EmployeeWrapper emp) {
        this.id = emp.getId();
        this.name = emp.getName();
        this.birthday = emp.getBirthday();
        this.phone = emp.getPhone();
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
