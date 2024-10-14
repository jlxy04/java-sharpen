package com.test.jdbc;

import java.sql.*;

public class TestJdbc {

    static final String JDBC_URL = "jdbc:mysql://120.76.157.34:3306/test_1";
    static final String JDBC_USER = "test";
    static final String JDBC_PASSWORD = "$test=1+2*)Gs";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String sql = "SELECT id, name, age FROM user WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // 开启手动提交事务
            conn.setAutoCommit(false);

            String updateSql = "UPDATE user SET age = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setInt(1, 30);
            updateStmt.setInt(2, 2);
            int rowsAffected = updateStmt.executeUpdate();
            System.out.println(rowsAffected + " rows updated successfully.");

            // 提交事务
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 回滚事务
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
