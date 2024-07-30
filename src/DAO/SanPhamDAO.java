/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.SanPham;
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
public class SanPhamDAO {
    public static ArrayList<SanPham> layDanhsachSanPham(){
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        try {
            String sql = "select * from PRODUCT";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                SanPham product = new SanPham();
                product.setIdproduct(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getFloat(3));
                product.setDateproduct(rs.getDate(4));
                product.setQuantity(rs.getInt(5));
                product.setIdcategory(rs.getInt(6));
                product.setIdsupplier(rs.getInt(7));
                dsSanPham.add(product);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsSanPham;
    }
    public static ArrayList<String> layDanhsachTenSanPham(){
        ArrayList<String> dsSanPham = new ArrayList<>();
        try {
            String sql = "select name from PRODUCT";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                dsSanPham.add(rs.getString(1));
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsSanPham;
    }
      public static void deleteProduct(String id){
       String sql = " exec deleteProduct '"+id+"'";
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       provider.executeUpdate(sql);
       provider.close();
   }
    public static void updateProduct(String idproduct, String name, String price, String dateproduct, String quantity, String idcategory, String idsupplier){
       String sql = " update PRODUCT set NAME = ? ,PRICE  = ? ,DATEPRODUCT  = ? ,QUANTITY  =?,IDCATEGORY  = ? ,IDSUPPLIER  = ? where IDPRODUCT  = ?";
       PreparedStatement preparedStatement;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
        try {
            preparedStatement = provider.connection.prepareCall(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, price);
            preparedStatement.setString(3, dateproduct);
            preparedStatement.setString(4, quantity);
            preparedStatement.setInt(5, Integer.parseInt(idcategory));
            preparedStatement.setString(6, idsupplier);
            preparedStatement.setString(7, idproduct);
            preparedStatement.executeUpdate();
            provider.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    public static void insertProduct(String name, String price, String dateProduct, String quantity, String idCategory, String idSupplier) {
    String sql = " INSERT INTO PRODUCT (NAME, PRICE, DATEPRODUCT, QUANTITY, IDCATEGORY, IDSUPPLIER) VALUES (?, ?, ?, ?, ?, ?)";
    SQLServerProvider provider = new SQLServerProvider();
    try {
        provider.open();
        PreparedStatement preparedStatement = provider.connection.prepareCall(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, Double.parseDouble(price)); // Assuming price is a double
        preparedStatement.setString(3, dateProduct);
        preparedStatement.setInt(4, Integer.parseInt(quantity)); // Assuming quantity is an integer
        preparedStatement.setInt(5, Integer.parseInt(idCategory));
        preparedStatement.setString(6, idSupplier);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException | NumberFormatException ex) {
        // Handle specific exceptions separately if needed
        Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        // Handle user-facing error here, maybe throw a custom exception or return an error message
    } finally {
        provider.close();
    }
}
     public static ArrayList<SanPham> findProduct(String search){
       String sql = "exec findProduct ?";
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
       PreparedStatement preparedStatement;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
        try {
            preparedStatement = provider.connection.prepareCall(sql);
            preparedStatement.setString(1, search);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                SanPham product = new SanPham();
                product.setIdproduct(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getFloat(3));
                product.setDateproduct(rs.getDate(4));
                product.setQuantity(rs.getInt(5));
                product.setIdcategory(rs.getInt(6));
                product.setIdsupplier(rs.getInt(7));
                dsSanPham.add(product);
            }
            provider.close();
            provider.close();
            preparedStatement.close();
            return dsSanPham;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsSanPham;
   }
}
