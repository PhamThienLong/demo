package com.example.qltvtt.entitywrapper;

public class AccountWrapper {
    private int Id;
    private String Name;
    private String Phone;
    private String Position;

    public int getId() {
        return Id;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setId(int id) {
        this.Id = id;
    }

}
