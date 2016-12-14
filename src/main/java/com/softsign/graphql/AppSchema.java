package com.softsign.graphql;

import graphql.Scalars;
import graphql.schema.*;

public class AppSchema {

    GraphQLSchema schema;

    public AppSchema() {

        GraphQLObjectType userType = GraphQLObjectType.newObject()
                .name("User")
                .description("A user")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(new GraphQLNonNull(Scalars.GraphQLLong)))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("lastName").type(Scalars.GraphQLString))
                .build();

        GraphQLObjectType queryType = GraphQLObjectType.newObject()
                .name("QueryType")
                .description("Main query to fetch data")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("user").type(userType).argument(GraphQLArgument.newArgument().name("id").type(new GraphQLNonNull(Scalars.GraphQLString)))
                        .dataFetcher(DataFetchers.userDataFetcher))
                .build();

        schema = GraphQLSchema.newSchema().query(queryType).build();
    }

    public GraphQLSchema getSchema() {
        return schema;
    }
}
