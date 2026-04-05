package com.example;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(5000);

        get("/", (req, res) -> {
            return "Сәлем, DevOps! Jenkins жұмыс істеп тұр!";
        });
    }
}
