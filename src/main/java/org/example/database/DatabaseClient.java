package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DatabaseClient
 */
public class DatabaseClient {
    static Connection conn;
    static Statement stmt;

    public static    void initiate() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.iaffaaaqyxfouhtxibey&password=amarsonarbangla");
            if (conn != null) {
                System.err.println("Database connnected successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runSQL(String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                System.out.println("ID: " + id + ", Content: " + content);
            }
            System.out.println("db query successfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
