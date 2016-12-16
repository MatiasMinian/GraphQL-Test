package com.softsign.graphql;

import com.softsign.model.transports.Bike;
import com.softsign.model.transports.Car;
import com.softsign.model.transports.Transport;
import com.softsign.model.transports.Yacht;
import graphql.Scalars;
import graphql.schema.*;

public class AppSchema {

    GraphQLSchema schema;
    GraphQLObjectType carType;
    GraphQLObjectType bikeType;
    GraphQLObjectType yachtType;

    public AppSchema() {

        TypeResolver transportTypeResolver = (object -> {
            Transport transport = (Transport) object;
            if (transport instanceof Car) {
                return getCarType();
            }
            if (transport instanceof Bike) {
                return getBikeType();
            }
            if (transport instanceof Yacht) {
                return getYachtType();
            }
            return null;
        });

        GraphQLInterfaceType transportInterface = GraphQLInterfaceType.newInterface()
                .name("Transport")
                .description("A transport")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(new GraphQLNonNull(Scalars.GraphQLInt)))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("medium").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("brand").type(Scalars.GraphQLString))

                // TODO Check if this should go here or if with inline fragments just asking for a field of the ObjectType is enough
                .field(GraphQLFieldDefinition.newFieldDefinition().name("category").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("engineSize").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("type").type(Scalars.GraphQLString))

                .typeResolver(transportTypeResolver)
                .build();

        carType = GraphQLObjectType.newObject()
                .name("Car")
                .description("A car")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(new GraphQLNonNull(Scalars.GraphQLInt)))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("medium").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("brand").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("category").type(Scalars.GraphQLString))
                .build();

        bikeType = GraphQLObjectType.newObject()
                .name("Bike")
                .description("A bike")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(new GraphQLNonNull(Scalars.GraphQLInt)))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("medium").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("brand").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("engineSize").type(Scalars.GraphQLString))
                .build();

        yachtType = GraphQLObjectType.newObject()
                .name("Yacht")
                .description("A yacht")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(new GraphQLNonNull(Scalars.GraphQLInt)))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("medium").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("brand").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("type").type(Scalars.GraphQLString))
                .build();



        GraphQLObjectType userType = GraphQLObjectType.newObject()
                .name("User")
                .description("A user")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(new GraphQLNonNull(Scalars.GraphQLInt)))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("lastName").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("sex").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("transports").type(new GraphQLList(transportInterface))
                        .dataFetcher(DataFetchers.userTransportsDataFetcher))
                .build();

        GraphQLObjectType queryType = GraphQLObjectType.newObject()
                .name("QueryType")
                .description("Main query to fetch data")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("user").type(userType).argument(GraphQLArgument.newArgument().name("id").type(new GraphQLNonNull(Scalars.GraphQLInt)))
                        .dataFetcher(DataFetchers.userDataFetcher))
                .build();

        schema = GraphQLSchema.newSchema().query(queryType).build();
    }

    public GraphQLSchema getSchema() {
        return schema;
    }

    public GraphQLObjectType getCarType() {
        return carType;
    }

    public GraphQLObjectType getBikeType() {
        return bikeType;
    }

    public GraphQLObjectType getYachtType() {
        return yachtType;
    }
}
