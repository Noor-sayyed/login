package com.zensar.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zensar.utility.DBUtil;

public class loginRepository {

	public boolean checkLogin(String userName,String password) {
        boolean result=false;
        Connection con=DBUtil.getDbConnection();
        String sql="select * from login where username=?";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
             pst.setString(1,userName);
             ResultSet rs=pst.executeQuery();
             while(rs.next()) {
                 String passwordFromDb = rs.getString("passoword");
                 if(password.equals(passwordFromDb)){
                     result=true;
                 }
             }
        }catch(Exception e) {
             e.printStackTrace();
         }
     return result;
    }
}
