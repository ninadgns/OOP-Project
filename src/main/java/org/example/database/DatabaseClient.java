package org.example.database;

import org.example.database.Pair;
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

import org.example.Manage.Hotel;

import java.sql.ResultSetMetaData;
import java.io.File;
import java.util.Base64;
import javafx.scene.image.Image;

/**
 * DatabaseClient
 */
public class DatabaseClient {
    public static Connection conn;
    public static Statement stmt;

    public static void initiate() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.iaffaaaqyxfouhtxibey&password=amarsonarbangla");
            if (conn != null) {
                System.err.println("Database connnected successfully");
                var rs = DatabaseClient.runSQL("select max(id) from hotels");
                rs.next();
                Hotel.lastHotelID = rs.getInt("max");

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
<<<<<<< Updated upstream
           // System.out.println("db query successful");
=======
          //  System.out.println("db query successful");
>>>>>>> Stashed changes
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

    public static void saveFile(String base64String) {

        // Loading the Base64 encoded image
        byte[] imageBytes = Base64.getDecoder().decode(base64String);

        try {
            FileOutputStream fos = new FileOutputStream("output.jpg");
            fos.write(imageBytes);
            fos.close();
<<<<<<< Updated upstream
           // System.out.println("chobi saved");
=======
            // System.out.println("chobi saved");
>>>>>>> Stashed changes
        } catch (IOException e) {
            e.printStackTrace();
        }
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
<<<<<<< Updated upstream
=======
        // System.out.println(sql);
>>>>>>> Stashed changes
        ResultSet rs = runSQL(sql);
        List<Map<String, Object>> rl = null;
        try {
            rl = resultSetToArray(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rl;

    }

    public static void insertMessage(String receiver, String sender, String message) {
        try {
            conn.createStatement()
                    .executeUpdate("insert into messages (sender_id, receiver_id, content) values ('"
                            + sender + "', '" + receiver + "','" + message + "')");
<<<<<<< Updated upstream
            } catch (Exception e) {
=======
            // System.out.println("insert into messages (sender_id, receiver_id, content) values ('"
                    // + sender + "', '" + receiver + "','" + message + "')");
        } catch (Exception e) {
>>>>>>> Stashed changes
            e.printStackTrace();
        }
    }

    public static List<Pair<String, String>> fetchMessage(String receiver) {
<<<<<<< Updated upstream
=======
        // System.out.println("select * from messages  where receiver_id = " + receiver);
>>>>>>> Stashed changes
        var rs = runSQL("select * from messages  where receiver_id = " + receiver);
        List<Pair<String, String>> ret = new ArrayList<>();
        try {
            if (rs != null)
                while (rs.next()) {
                    var sender = rs.getString("sender_id");
                    var content = rs.getString("content");
                    ret.add(new Pair<String, String>(sender, content));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static List<Map<String, Object>> fetchWhere(String tableName, String whereClause) {
        ResultSet rs = null;
        List<Map<String, Object>> rl = null;
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE " + whereClause;
<<<<<<< Updated upstream
=======
            // System.out.println(sql);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
        // System.out.println(sql);
>>>>>>> Stashed changes
        try {
            conn.createStatement().executeUpdate(sql);

        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            // e.getMessage();
        }
    }

}
