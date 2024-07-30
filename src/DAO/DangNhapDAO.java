/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import GUI.Main;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author tranc
 */
public class DangNhapDAO {
    
    public static String getIdEmployeesByUsername(String user){
        String id = null;
        try {
            String sql = String.format("select IDEMP from ACCOUNT where USERNAME = '%s';",user);
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            rs.next();
            id = rs.getString(1);
            provider.close();
            return id;
        } catch (Exception e) {
        }
        return id;
    }
    
}
