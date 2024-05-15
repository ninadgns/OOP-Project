package org.example.database;

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

    public static List<Map<String, Object>> resultSetToArray(ResultSet rs) throws SQLException {
        // Get the metadata
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
