/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author You
 */
public class UserData {
    
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private int deleteFlg;
    
    public int getUserID(){
        return this.userID;
    }
    public void setUserID(String userID){
        if(userID != null){
            this.userID = Integer.parseInt(userID);
        }else{
            this.userID = 0;
        }
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if(name != null){
            this.name = name;
        }else{
            this.name = "";
        }
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        if(password != null){
            this.password = password;
        }else{
            this.password = "";
        }
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        if(mail != null){
            this.mail = mail;
        }else{
            this.mail = "";
        }
    }
    
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        if(address != null){
            this.address = address;
        }else{
            this.address ="";
        }
    }
    
    public int getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        if(total != null){
            this.total = Integer.parseInt(total);
        }else{
            this.total = 0;
        }
    }
    
    
    public int getDeleteFlg(){
        return this.deleteFlg;
    }
    public void setDeleteFlg(String deleteFlg){
        if(deleteFlg != null){
            this.deleteFlg = Integer.parseInt(deleteFlg);
        }else{
            this.deleteFlg = 0;
        }
    }
    
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("password");
        }
        if(this.mail.equals("")){
            chkList.add("mail");
        }
        if(this.address.equals("")){
            chkList.add("address");
        }
        
        return chkList;
    }
    
    public UserDataDTO UD2UDDMappint(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
        udd.setTotal(this.total);
        udd.setDeleteFlg(this.deleteFlg);
        
        return udd;
    }
}
