package com.softsign.model.transports;

public class Yacht extends Transport {

    String type;

    public Yacht(Integer id, String name, String medium, String brand, String type) {
        super(id, name, medium, brand);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
