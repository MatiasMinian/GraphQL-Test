package com.softsign.graphql;

import com.softsign.model.User;
import com.softsign.model.transports.Bike;
import com.softsign.model.transports.Car;
import com.softsign.model.transports.Transport;
import com.softsign.model.transports.Yacht;

import java.util.ArrayList;
import java.util.List;

public class AppDataset {

    public static List<User> users = new ArrayList<>();
    public static List<Transport> transports = new ArrayList<>();

    static {

        Car matiasCar = new Car(1, "Car", "Land", "Ford", "Compact");
        Bike matiasBike = new Bike(2, "Bike", "Land", "Yamaha", "500cc");
        List<Transport> matiasTransports = new ArrayList<>();
        matiasTransports.add(matiasCar);
        matiasTransports.add(matiasBike);

        Car fernandoCar = new Car(3, "Car", "Land", "Ford", "SUV");
        List<Transport> fernandoTransports = new ArrayList<>();
        fernandoTransports.add(fernandoCar);

        Yacht federicoYacht = new Yacht(4, "Yacht", "Sea", "Sunreef", "Luxury");
        List<Transport> federicoTransports = new ArrayList<>();
        federicoTransports.add(federicoYacht);

        transports.add(matiasCar);
        transports.add(matiasBike);
        transports.add(fernandoCar);
        transports.add(federicoYacht);

        User matias = new User(1, "Matias", "Minian", "Male", matiasTransports);
        User fernando = new User(2, "Fernando", "Pessina", "Male", fernandoTransports);
        User pablo = new User(3, "Pablo", "Alice", "Male", null);
        User federico = new User(4, "Federico", "Fernandez", "Male", federicoTransports);
        User andrea = new User(5,"Andrea", "Gomez", "Female", null);

        users.add(matias);
        users.add(fernando);
        users.add(pablo);
        users.add(federico);
        users.add(andrea);
    }
}
