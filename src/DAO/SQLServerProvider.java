/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tranc
 */
public class SQLServerProvider {
    public static Connection connection;
    String strServer = "LAPTOPTQT03";
    String strDatabase = "qlsieuthi";
    public static String username;
    public void open()
    {    
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
              String connectionUrl = "jdbc:sqlserver://"+strServer
                    +":1433;databaseName="+strDatabase
                    +";user =sa;password=123;";
              connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    public boolean checkConnection(String userName,String passW){
        try {
            username = userName;
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
              String connectionUrl = "jdbc:sqlserver://"+strServer
                    +":1433;databaseName="+strDatabase
                    +";user ="+userName+";password="+passW+";trustServerCertificate=true;";
              connection = DriverManager.getConnection(connectionUrl);
              return true;
        } catch (ClassNotFoundException | SQLException e) {
                        System.out.println("Rỗng");

            return false;
        }
    }
    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
        }
    }
    public ResultSet execteQuery(String sql){
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
        
    }
    public int executeUpdate(String sql){
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (SQLException e) {
        }
        return n;
    }
    
    public String getUserRole(String username) throws SQLException {
      
        String role = ""; // Khởi tạo vai trò với giá trị mặc định

        // Thay thế thông tin kết nối vào chuỗi kết nối
        String connectionUrl = "jdbc:sqlserver://" + strServer + ":1433;databaseName=" + strDatabase + ";user=sa;password=123;";

        // Sử dụng kết nối đến cơ sở dữ liệu
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            // Chuẩn bị truy vấn SQL
            String sql = "SELECT dbo.CheckLoginAccess(?) AS Role";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                // Thực hiện truy vấn SQL và lấy kết quả
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Lấy vai trò từ kết quả truy vấn
                        role = resultSet.getString("Role");
                    }
                }
            }
        }

        return role;
    }
}
