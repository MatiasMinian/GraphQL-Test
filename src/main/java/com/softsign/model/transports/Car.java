package com.softsign.model.transports;

public class Car extends Transport {

    String category;


    public Car(Integer id, String name, String medium, String brand, String category) {
        super(id, name, medium, brand);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
