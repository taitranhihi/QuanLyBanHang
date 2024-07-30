/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.Loai;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LoaiDAO {
     public static ArrayList<Loai> layDanhsachLoai(){
        ArrayList<Loai> dsLoai = new ArrayList<>();
        try {
            String sql = "select * from CATEGORY";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                Loai category = new Loai();
                category.setIdcategory(rs.getInt(1));
                category.setName(rs.getString(2));
                dsLoai.add(category);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsLoai;
    }
      public static void deleteCategory(String id){
       String sql = " exec deleteCategory '"+id+"'";
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       provider.executeUpdate(sql);
       provider.close();
   }
      public static void updateCategory(String idcategory, String name){
       String sql = "update CATEGORY set NAME = ? where IDCATEGORY  = ?";
       PreparedStatement preparedStatement;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
        try {
            preparedStatement = provider.connection.prepareCall(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, idcategory);
           
            preparedStatement.executeUpdate();
            provider.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
      public static void insertCategory(String name) {
    String sql = "INSERT INTO CATEGORY (NAME) VALUES (?)";
    SQLServerProvider provider = new SQLServerProvider();
    try {
        provider.open();
        PreparedStatement preparedStatement = provider.connection.prepareCall(sql);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException ex) {
        Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        // Handle user-facing error here, maybe throw a custom exception or return an error message
    } finally {
        provider.close();
    }
}

  public static ArrayList<Loai> findCategory(String search){
       String sql = "exec findCategory ?";
        ArrayList<Loai> dsLoai = new ArrayList<>();
       PreparedStatement preparedStatement;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
        try {
            preparedStatement = provider.connection.prepareCall(sql);
            preparedStatement.setString(1, search);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Loai category = new Loai();
                category.setIdcategory(rs.getInt(1));
                category.setName(rs.getString(2));
             
                dsLoai.add(category);
            }
            provider.close();
            provider.close();
            preparedStatement.close();
            return dsLoai;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLoai;
   }
}
