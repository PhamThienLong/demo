package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.DetailWrapper;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "detail")
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_detail")
    private Integer id;
    @Column(name = "book_id")
    private Integer boo;
    private int quantity;
    private int price;
    @Column(name = "bill_id")
    private Integer bil;

    public Detail() {
    }

    public Detail(DetailWrapper det) {
        this.id = det.getId();
        this.boo = det.getBoo();
        this.quantity = det.getQuantity();
        this.price = det.getPrice();
        this.bil = det.getBil();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoo() {
        return boo;
    }

    public void setBoo(Integer boo) {
        this.boo = boo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getBil() {
        return bil;
    }

    public void setBil(Integer bil) {
        this.bil = bil;
    }
}
