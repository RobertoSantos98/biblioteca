package com.biblioteca.biblioteca;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

  private static final String URL = "jdbc:h2:mem:testdb";

  private static final String USER = "sa";

  private static final String PASSWORD = "";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void createTables() {
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement()) {

      String sql = "CREATE TABLE IF NOT EXISTS Livros (" +
                   "id INT PRIMARY KEY AUTO_INCREMENT, " +
                   "titulo VARCHAR(255), " +
                   "autor VARCHAR(255), " +
                   "emprestado BOOLEAN" +
                   ")";
      stmt.execute(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
