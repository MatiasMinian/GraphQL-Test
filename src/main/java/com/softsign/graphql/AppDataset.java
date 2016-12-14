package com.softsign.graphql;

import com.softsign.model.User;

import java.util.ArrayList;
import java.util.List;

public class AppDataset {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Matias", "Minian", "Male"));
        users.add(new User(2, "Fernando", "Pessina", "Male"));
        users.add(new User(3, "Pablo", "Alice", "Male"));
        users.add(new User(4, "Federico", "Fernandez", "Male"));
        users.add(new User(5, "Andrea", "Gomez", "Female"));
    }
}
