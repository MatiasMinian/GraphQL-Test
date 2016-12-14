package com.softsign.graphql;

import com.softsign.model.User;

import java.util.ArrayList;
import java.util.List;

public class AppDataset {

    public static List<User> users = new ArrayList<>();

    public AppDataset() {
        initialize();
    }


    private void initialize() {
        users.add(new User(1l, "Matias", "Minian"));
        users.add(new User(2l, "Fernando", "Pessina"));
    }








}
