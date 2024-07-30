/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import POJO.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SupplierDAO {
    public static ArrayList<Supplier> layDanhsachNCC(){
        ArrayList<Supplier> dsNCC = new ArrayList<>();
        try {
            String sql = "select * from SUPPLIER";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                Supplier spr = new Supplier();
                spr.setIdSupplier(rs.getInt(1));
                spr.setName(rs.getString(2));
                spr.setPhone(rs.getString(3));
                spr.setAddress(rs.getString(4));
                spr.setEmail(rs.getString(5));
                dsNCC.add(spr);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsNCC;
    }
    

    
    public boolean themNhaCungCap(String tenNCC, String sdtNCC, String dcNCC, String emailNCC) {
        try {
            String sql = "INSERT INTO SUPPLIER (NAME, PHONE, ADDRESS, EMAIL) VALUES (?, ?, ?, ?)";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();

            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);

            preparedStatement.setString(1, tenNCC);
            preparedStatement.setString(2, sdtNCC);
            preparedStatement.setString(3, dcNCC);
            preparedStatement.setString(4, emailNCC);

            int rowsAffected = preparedStatement.executeUpdate();

            provider.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean xoaNhaCungCap(String idNCC)   {
        try {
            String sqlDelete = "DELETE FROM SUPPLIER WHERE IDSUPPLIER = ?";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sqlDelete);
            preparedStatement.setString(1, idNCC);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            return false;
        }   
    }
    
    public static List<Supplier> timKiemNhaCungCap( String searchText) {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            String sqlSearch = "SELECT * FROM SUPPLIER WHERE NAME LIKE ? OR IDSUPPLIER LIKE ?";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sqlSearch);
            preparedStatement.setString(1, "%" + searchText + "%");
            preparedStatement.setString(2, "%" + searchText + "%"); 
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Supplier supplier = new Supplier();
                    supplier.setIdSupplier(rs.getInt("IDSUPPLIER"));
                    supplier.setName(rs.getString("NAME"));
                    supplier.setPhone(rs.getString("PHONE"));
                    supplier.setAddress(rs.getString("ADDRESS"));
                    supplier.setEmail(rs.getString("EMAIL"));
                    suppliers.add(supplier);
                }
            }
        } catch (SQLException e) {
        }
        return suppliers;
    }

    public static boolean capNhatNhaCungCap(String idNCC, String tenNCC, String sdtNCC, String dcNCC, String emailNCC) {
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();      

            String sqlUpdate = "UPDATE SUPPLIER SET NAME = ?, PHONE = ?, ADDRESS = ?, EMAIL = ? WHERE IDSUPPLIER = ?";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, tenNCC);
            preparedStatement.setString(2, sdtNCC);
            preparedStatement.setString(3, dcNCC);
            preparedStatement.setString(4, emailNCC);
            preparedStatement.setString(5, idNCC);

            int rowsAffected = preparedStatement.executeUpdate();
            provider.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            return false;
        }
    }

}
