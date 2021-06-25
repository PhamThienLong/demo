package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.BookWrapper;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "author_id")
    private Integer aut;
    @Column(name = "genre_id")
    private Integer gen;
    @Column(name = "publisher_id")
    private Integer pub;
    @Column(name = "provider_id")
    private Integer pro;
@Column(name = "publish_year")
    private String year;

    public Book() {
    }

    public Book(BookWrapper bow) {
        this.id = bow.getId();
        this.name = bow.getName();
        this.aut = bow.getAut();
        this.gen = bow.getGen();
        this.pub = bow.getPub();
        this.pro = bow.getPro();
        this.year = bow.getYear();
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

    public Integer getAut() {
        return aut;
    }

    public void setAut(Integer aut) {
        this.aut = aut;
    }

    public Integer getGen() {
        return gen;
    }

    public void setGen(Integer gen) {
        this.gen = gen;
    }

    public Integer getPub() {
        return pub;
    }

    public void setPub(Integer pub) {
        this.pub = pub;
    }

    public Integer getPro() {
        return pro;
    }

    public void setPro(Integer pro) {
        this.pro = pro;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
