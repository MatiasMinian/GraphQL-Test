package com.softsign.model;

public class User {

    private Integer id;
    private String name;
    private String lastName;
    private String sex;

    public User(Integer id, String name, String lastName, String sex) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }
}
