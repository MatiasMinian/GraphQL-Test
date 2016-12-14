package com.softsign.model.transports;

public abstract class Transport {

    Integer id;
    String name;
    String medium;
    String brand;

    public Transport(Integer id, String name, String medium, String brand) {
        this.id = id;
        this.name = name;
        this.medium = medium;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMedium() {
        return medium;
    }

    public String getBrand() {
        return brand;
    }
}
