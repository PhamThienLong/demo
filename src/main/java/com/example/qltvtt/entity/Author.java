package com.example.qltvtt.entity;

import com.example.qltvtt.entitywrapper.AuthorWrapper;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int Id;
    @Column(name = "author_name")
    private String name;
    private String note;

    public Author() {
    }

    public Author(AuthorWrapper auw) {
        this.Id = auw.getId();
        this.name = auw.getName();
        this.note = auw.getNote();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
