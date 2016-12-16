package com.softsign.model;

import com.softsign.model.transports.Transport;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private String lastName;
    private String sex;
    private List<Transport> transports = new ArrayList<>();

    public User(Integer id, String name, String lastName, String sex, List<Transport> transports) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        if (transports != null) {
            this.transports.addAll(transports);
        }
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

    public List<Transport> getTransports() {
        return transports;
    }
}
