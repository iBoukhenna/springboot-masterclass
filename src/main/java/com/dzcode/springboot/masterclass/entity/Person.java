package com.dzcode.springboot.masterclass.entity;


import java.util.Date;

public class Person {

    private long id;
    private String name;
    private String location;
    private Date birthData;

    public Person() {

    }

    public Person(long id, String name, String location, Date birthData) {
        super();
        this.id = id;
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthData=" + birthData +
                '}';
    }
}
