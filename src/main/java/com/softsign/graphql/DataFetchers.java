package com.softsign.graphql;

import graphql.schema.DataFetcher;

public class DataFetchers {

    public static DataFetcher userDataFetcher = (environment -> AppDataset.users.get((Integer) environment.getArguments().get("id") - 1));

}
