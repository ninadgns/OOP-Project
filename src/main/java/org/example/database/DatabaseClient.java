package org.example.database;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.ResultSetMetaData;
import java.io.File;
import java.util.Base64;
import javafx.scene.image.Image;

/**
 * DatabaseClient
 */
public class DatabaseClient {
    static Connection conn;
    static Statement stmt;

    public static void initiate() {
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

    public static ResultSet runSQL(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // while (rs.next()) {
            // int id = rs.getInt("id");
            // String content = rs.getString("content");
            // System.out.println("ID: " + id + ", Content: " + content);
            // }
            System.out.println("db query successfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static String fileToString(File file) throws IOException {
        // Read the file into a byte array
        byte[] fileBytes;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteStream.write(buffer, 0, bytesRead);
            }
            fileBytes = byteStream.toByteArray();
        }

        // Encode the byte array to Base64 string
        return Base64.getEncoder().encodeToString(fileBytes);
    }

public static Image stringToImage(String encodedString) throws IOException {
        // Decode the Base64 string to byte array
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);

        // Create a temporary file to store the decoded image
        File tempFile = File.createTempFile("decoded_image", ".jpg");
        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            outputStream.write(decodedBytes);
        }
        // Return the File object representing the decoded image file
        return new Image(tempFile.toURI().toString());
    }


    public static List<Map<String, Object>> resultSetToArray(ResultSet rs) throws SQLException {
        
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // Prepare the result
        List<Map<String, Object>> resultList = new ArrayList<>();

        while (rs.next()) {
            // Each row will be a map
            Map<String, Object> row = new HashMap<>(columnCount);

            for (int i = 1; i <= columnCount; i++) {
                // Get the column name
                String colName = rsmd.getColumnName(i);
                // Get the value
                Object colVal = rs.getObject(i);
                // Add to map
                row.put(colName, colVal);
            }

            // Add the row to the result
            resultList.add(row);
        }

        return resultList;
    }

    public static List<Map<String, Object>> fetch(String tableName) {
        String sql = "select * from " + tableName;
        System.out.println(sql);
        ResultSet rs = runSQL(sql);
        List<Map<String, Object>> rl = null;
        try {
            rl = resultSetToArray(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rl;

    }

    public static List<Map<String, Object>> fetchWhere(String tableName, String whereClause) {
        ResultSet rs = null;
        List<Map<String, Object>> rl = null;
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE " + whereClause;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rl = resultSetToArray(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rl;
    }

    public static void insert(String tableName, String fields, String values) {
        String sql = "insert into " + tableName + "(" + fields + ") Values (" + values + ")";
        System.out.println(sql);
        try {
            conn.createStatement().executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
