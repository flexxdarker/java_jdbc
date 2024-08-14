package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:postgresql://ep-snowy-shadow-a5wjs5o9.us-east-2.aws.neon.tech:5432/depapis553db";
    private static final String USER = "depapis553db_owner";
    private static final String PASSWORD = "m03KVcwFIAsr";


    private static Connection connection;

    public static void main(String[] args) {
        try {
            createTable();
            Contact ivan = new Contact();
            ivan.setName("Каблучок Іван Іванович");
            ivan.setPhoneNumber("0000");
            ivan.setEmail("Soborna st. 109");
            ivan.setEmail("kabinvanovuch@gmail.com");
        } catch (Exception e){
            System.out.println("Something went wrong..." + e.getMessage());
        }
    }
    private static void createTable() throws SQLException{
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // SQL-запит для створення таблиці
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Phonebook (" +
                    "ID SERIAL PRIMARY KEY, " +
                    "Name VARCHAR(100) NOT NULL, " +
                    "PhoneNumber VARCHAR(15) NOT NULL, " +
                    "Email VARCHAR(100), " +
                    "Address VARCHAR(255)" +
                    ");";
            Statement command = connection.createStatement();

            // Виконання SQL-запиту на створення таблиці
            command.execute(createTableSQL);
            System.out.println("Успішно створено таблицю Phonebook :)");

            System.out.println("Good connection");
        }
        catch (Exception e){
            System.out.println("Error with connecting to db!!!");
        }

    }

}