package com.softsign.graphql;

import com.softsign.model.User;
import graphql.schema.DataFetcher;

public class DataFetchers {

    public static DataFetcher userDataFetcher = (environment -> AppDataset.users.get( (Integer)environment.getArguments().get("id") - 1));

    public static DataFetcher userTransportsDataFetcher = (environment -> ((User)environment.getSource()).getTransports());

}
