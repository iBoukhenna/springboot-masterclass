package com.dzcode.springboot.masterclass.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.util.Date;

@Entity
@NamedQuery(name = "find_all_users", query = "select u from User u")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String location;
    private Date birthData;

    public User() {

    }

    public User(long id, String name, String location, Date birthData) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthData = birthData;
    }

    public User(String name, String location, Date birthData) {
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthData=" + birthData +
                '}';
    }
}
