/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author You
 */
public class UserDataDAO {
    
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    public void insertLogin(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,password,mail,address,total,newDate,deleteFlg) VALUES(?,?,?,?,?,?,?)");
            st.setString(1,ud.getName());
            st.setString(2,ud.getPassword());
            st.setString(3,ud.getMail());
            st.setString(4,ud.getAddress());
            st.setInt(5,ud.getTotal());
            st.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
            st.setInt(7,ud.getDeleteFlg());
            st.executeUpdate();
            System.out.println("Insert Completed!!");
            
        }catch (SQLException sql_e){
            System.out.println("sql error " + sql_e.getMessage());
            throw new SQLException(sql_e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    //ログインチェック用
    public UserDataDTO loginCheck(UserDataDTO ud)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        UserDataDTO udd = new UserDataDTO();
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM user_t WHERE name = ? AND password = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            rs = st.executeQuery();
            while(rs.next()){
                if(rs.getString("name").equals(ud.getName()) &&
                        rs.getString("password").equals(ud.getPassword())){
                    udd.setUserID(rs.getInt("userID"));
                    udd.setName(rs.getString("name"));
                    udd.setPassword(rs.getString("password"));
                    udd.setMail(rs.getString("mail"));
                    udd.setAddress(rs.getString("address"));
                    udd.setTotal(rs.getInt("total"));
                    udd.setDeleteFlg(rs.getInt("deleteFlg"));
                    return udd;
                }
            }
            return udd;
        }catch(SQLException sql_e){
            System.out.println("sql error " + sql_e.getMessage());
            throw new SQLException(sql_e);
        }finally{
            if(con != null){
                con.close();
            }
            if(st != null){
                st.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }
}
