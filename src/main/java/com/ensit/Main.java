package com.ensit;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        // Set port from environment variable or default to 8080
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        port(port);

        // Serve static files from resources/static - MUST be done before route mapping
        staticFiles.location("/static");

        // Enable CORS for all origins
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        });

        // Handle preflight requests
        options("/*", (request, response) -> {
            return "OK";
        });


        // Health check endpoint
        get("/ping", (req, res) -> {
            res.type("application/json");
            Map<String, String> response = new HashMap<>();
            response.put("message", "pong");
            return gson.toJson(response);
        });

        // Calculator endpoint
        post("/calculate", (req, res) -> {
            res.type("application/json");
            try {
                Map<String, Object> requestData = gson.fromJson(req.body(), Map.class);
                String op = (String) requestData.get("op");
                double a = ((Number) requestData.get("a")).doubleValue();
                double b = ((Number) requestData.get("b")).doubleValue();

                double result = Calculator.apply(op, a, b);

                Map<String, Object> response = new HashMap<>();
                response.put("op", op);
                response.put("a", a);
                response.put("b", b);
                response.put("result", result);

                return gson.toJson(response);
            } catch (Exception e) {
                res.status(400);
                Map<String, String> error = new HashMap<>();
                error.put("error", "Invalid request: " + e.getMessage());
                return gson.toJson(error);
            }
        });

        System.out.println("Java Calculator App started on port " + port);
    }
}