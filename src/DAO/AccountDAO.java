/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tranc
 */
public class AccountDAO {
    public static ArrayList<Account> layDanhsachAccount(){
        ArrayList<Account> dsAccount = new ArrayList<Account>();
        try {
            String sql = "Select * from Account";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                Account acc = new Account();
                acc.setUserID(rs.getString(1));
                acc.setUsername(rs.getString(2));
                acc.setIdEmp(rs.getString(3));
                dsAccount.add(acc);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsAccount;
    }
  
    
}
