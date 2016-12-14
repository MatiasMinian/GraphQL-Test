package com.softsign.graphql;

import graphql.schema.DataFetcher;

public class DataFetchers {

    public static DataFetcher userDataFetcher = (environment -> AppDataset.users.get( Integer.valueOf((String)environment.getArguments().get("id")) - 1));

}
