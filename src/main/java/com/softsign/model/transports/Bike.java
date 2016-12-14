package com.softsign.model.transports;

public class Bike extends Transport {

    String engineSize;


    public Bike(Integer id, String name, String medium, String brand, String engineSize) {
        super(id, name, medium, brand);
        this.engineSize = engineSize;
    }

    public String getEngineSize() {
        return engineSize;
    }
}
