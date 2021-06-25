package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.UserWrapper;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public User() {
    }

    public User(UserWrapper usw) {
        this.id = usw.getId();
        this.name = usw.getName();
        this.address = usw.getAddress();
        this.phone = usw.getPhone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
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

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", user_name='" + name + '\'' +
                ", user_address='" + address + '\'' +
                ", user_phone='" + phone + '\'' +
                '}';
    }

    //    public void nhapdg(){
//        Scanner sn = new Scanner(System.in);
//        System.out.println("Nhập tên độc giả: ");
//        user_name = sn.nextLine();
//        System.out.println("Nhập giới tính độc giả: ");
//        gender = sn.nextLine();
//        System.out.println("Nhập trạng thái thẻ độc giả: ");
//        state = sn.nextLine();
//    }

}
