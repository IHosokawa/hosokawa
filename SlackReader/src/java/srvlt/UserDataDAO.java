/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srvlt;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import base.DBManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author You
 */
public class UserDataDAO {
    
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    //ユーザーIDを登録
    public void insert(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement("INSERT INTO user_t(userName,password) VALUES(?,?)");
            ps.setString(1, udd.getUserName());
            ps.setString(2, udd.getPassword());
            ps.executeUpdate();
            System.out.println("Insert completed!!");
        }catch(SQLException sql_e){
            System.out.println(sql_e.getMessage());
            throw new SQLException(sql_e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    //ユーザーID重複チェック
    public boolean overlapSearch(UserDataDTO udd)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM user_t WHERE userName = ?");
            ps.setString(1, udd.getUserName());
            rs = ps.executeQuery();
            return rs.next();
        }catch(SQLException sql_e){
            System.out.println(sql_e.getMessage());
            throw new SQLException(sql_e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    //ログインチェック
    public UserDataDTO loginSearch(UserDataDTO udd)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM user_t WHERE userName = ? and password = ?");
            ps.setString(1, udd.getUserName());
            ps.setString(2, udd.getPassword());
            rs = ps.executeQuery();
            while(rs.next()){
                udd.setUserID(rs.getInt("userID"));
                udd.setUserName(rs.getString("userName"));
                udd.setPassword(rs.getString("password"));
                udd.setDelFlg(rs.getInt("delFlg"));
            }
            return udd;
        }catch(SQLException sql_e){
            System.out.println(sql_e.getMessage());
            throw new SQLException(sql_e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    //ログイン成功したユーザーの登録データをArrayListで返す
    public HashMap loginDataSeach(UserDataDTO udd)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HashMap<Integer,UserDataDTO> map = new HashMap<Integer,UserDataDTO>();
        int i = 0;
        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM regist_t WHERE userID = ?");
            ps.setInt(1, udd.getUserID());
            rs = ps.executeQuery();
            while(rs.next()){
                UserDataDTO aludd = new UserDataDTO(); 
                aludd.setRegistID(rs.getInt("registID"));
                aludd.setRegistUrl(rs.getString("registUrl"));
                aludd.setRegistFlg(rs.getInt("registFlg"));
                aludd.setUserID(rs.getInt("userID"));
                map.put(i,aludd);
                i++;//ひとまずKeyはInteger　余裕があったらStringにして検索機能
            }
            udd.setRegistData(map);
            
            return map;
        }catch (SQLException sql_e){
            System.out.println(sql_e.getMessage());
            throw new SQLException(sql_e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public void registInsert(UserDataDTO udd)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement("INSERT INTO regist_t(registUrl,userID) VALUE(?,?)");
            ps.setString(1, udd.getRegistUrl());
            ps.setInt(2, udd.getUserID());
            ps.executeUpdate();
            System.out.println("Insert Completed!!");
        }catch(SQLException sql_e){
            System.out.println(sql_e.getMessage());
            throw new SQLException(sql_e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
}
