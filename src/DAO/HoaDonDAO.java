/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import POJO.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDonDAO {
    
    //Thêm 
    public static ArrayList<HoaDon> layDanhsacHoaDon(){
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        try {
            String sql = "select * from BILL";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                HoaDon spr = new HoaDon();
                spr.setMaHoaDon(rs.getString(1));
                spr.setTongTien(rs.getFloat(2));
                spr.setNgayLap(rs.getString(3));
                spr.setMaKhachHang(rs.getString(4));
                dsHD.add(spr);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsHD;
    }
    public static double getProductPriceByName(String productName)
    {  
        double price = 0;
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            String sql = "SELECT PRICE FROM PRODUCT WHERE NAME = ?";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                price = resultSet.getDouble("PRICE");
        }
        provider.close();   
        } catch (Exception e) {
        }
        return price;
    }
    
    public static float tinhTongTien(DefaultTableModel model) 
    {
        float tongTien = (float) 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            double thanhTien = Double.parseDouble(model.getValueAt(i, 3).toString());
            tongTien += thanhTien;
        }

        return tongTien;
    }
    
    public static boolean luuHoaDonVaoCSDL(String ngayLap, String tenNguoiLap, float tongTien) {
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();

            if (provider.connection == null) {
                System.out.println("Không thể mở kết nối đến cơ sở dữ liệu.");
                return false;
            }

            String query = "SELECT IDUSER FROM ACCOUNT WHERE NAME = ?";
            PreparedStatement queryStmt = provider.connection.prepareStatement(query);
            queryStmt.setString(1, tenNguoiLap);
            ResultSet resultSet = queryStmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Không tìm thấy người dùng với tên: " + tenNguoiLap);
                return false;
            }

            byte[] maNguoiLapBytes = resultSet.getBytes("IDUSER");

            String sql = "INSERT INTO BILL (TOTALPRICE, BILLDATE, IDUSER) VALUES (?, ?, ?)";
            PreparedStatement pstmt = provider.connection.prepareStatement(sql);
            pstmt.setFloat(1, tongTien);
            pstmt.setString(2, ngayLap);
            pstmt.setBytes(3, maNguoiLapBytes);

            int rowsAffected = pstmt.executeUpdate();

            provider.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
     
     
    public static List<String> loadLoaiSP() {
        List<String> categoryNames = new ArrayList<>();
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            String sql = "SELECT NAME FROM CATEGORY";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            ResultSet rs  = preparedStatement.executeQuery();

            while (rs.next()) {
                String categoryName = rs.getString("NAME");
                categoryNames.add(categoryName);
            }
            provider.close();
        } catch (Exception e) {
        }
        return categoryNames;
    }

    
    public static List<String> loadProductNames(int categoryID) {
        List<String> productNames = new ArrayList<>();
        
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            String sql = "SELECT NAME FROM PRODUCT WHERE IDCATEGORY = ?";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            ResultSet rs  = preparedStatement.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("NAME");
                productNames.add(productName);
            }
            provider.close();
        } catch (Exception e) {
        }
        return productNames;
    }
    
    public int getCategoryIDByName(String categoryName){
        int categoryID = 0;
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            String sql = "SELECT IDCATEGORY FROM CATEGORY WHERE NAME = ?";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                categoryID  = resultSet.getInt("IDCATEGORY");
            }
        provider.close();   
        } catch (Exception e) {
        }
        return categoryID;
    }
    
    public static ArrayList<HoaDon> layDanhSachHoaDonTheoKhoangThoiGian(Date ngayTruoc, Date ngaySau) {
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        String sql = "SELECT * FROM BILL WHERE BILLDATE BETWEEN ? AND ?";
        try 
        {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setString(1, sdf.format(ngayTruoc));
            preparedStatement.setString(2, sdf.format(ngaySau));
            ResultSet rs = preparedStatement.executeQuery();
            
           
               
               while(rs.next()){
                HoaDon spr = new HoaDon();
                spr.setMaHoaDon(rs.getString(1));
                spr.setTongTien(rs.getFloat(2));
                spr.setNgayLap(rs.getString(3));
                spr.setMaKhachHang(rs.getString(4));
                dsHD.add(spr);
            }
               provider.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHD;
    }

 
}
