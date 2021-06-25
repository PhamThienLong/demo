package com.example.qltvtt.entitywrapper;

public class BookWrapper {

    private Integer id;
    private String name;
    private Integer aut;
    private Integer gen;
    private Integer pub;
    private Integer pro;
    private String year;


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
