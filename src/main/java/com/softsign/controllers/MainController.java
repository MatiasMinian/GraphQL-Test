package com.softsign.controllers;

import com.softsign.graphql.AppSchema;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class MainController {

    GraphQL graphQL = new GraphQL(new AppSchema().getSchema());

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public Object hello(@RequestBody Map body) {
        String query = (String) body.get("query");
        //Map<String, Object> variables = (Map<String, Object>) body.get("arguments");
        ExecutionResult executionResult = graphQL.execute(query);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }

}
