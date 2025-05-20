package com.effigo.hrms.api;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class HrmsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrmsApiApplication.class, args);
    }
    @PostConstruct
    public void testDbConnection() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://database-1-instance-1.cps6mmeuexfi.ap-south-1.rds.amazonaws.com:5432/postgres",
                "postgres",
                "XfMJndKcWsDRzOFOCQdOkhddkMsKyKQz")) {
            System.out.println("✅ DB Connection SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}