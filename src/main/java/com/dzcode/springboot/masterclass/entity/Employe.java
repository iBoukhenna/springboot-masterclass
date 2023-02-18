package com.dzcode.springboot.masterclass.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.util.Date;

@Entity
@NamedQuery(name = "find_all_employes", query = "select e from Employe e")
public class Employe {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String location;
    private Date birthData;

    public Employe() {

    }

    public Employe(long id, String name, String location, Date birthData) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthData = birthData;
    }

    public Employe(String name, String location, Date birthData) {
        super();
        this.name = name;
        this.location = location;
        this.birthData = birthData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthData() {
        return birthData;
    }

    public void setBirthData(Date birthData) {
        this.birthData = birthData;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthData=" + birthData +
                '}';
    }
}
