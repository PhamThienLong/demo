package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.GenreWrapper;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genre")
@Data
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;
    @Column(name = "genre_name")
    private String name;

    public Genre() {
    }

    public Genre(GenreWrapper gen) {
        this.id = gen.getId();
        this.name = gen.getName();
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
}
