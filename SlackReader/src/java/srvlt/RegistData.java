/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srvlt;

/**
 *
 * @author You
 */
public class RegistData {
    private int registID;
    private String registUrl;
    private int registFlg;
    private int userID;
    
    public int getRegistID(){
        return this.registID;
    }
    public void setRegistID(int registID){
        this.registID = registID;
    }
    
    public String getRegistUrl(){
        return this.registUrl;
    }
    public void setRegistUrl(String registUrl){
        if(registUrl != null){
            this.registUrl = registUrl;
        }else{
            this.registUrl = "";
        }
    }
    
    public int getRegistFlg(){
        return this.registFlg;
    }
    public void setRegistFlg(int registFlg){
        if( registFlg == 0 || registFlg == 1){
            this.registFlg = registFlg;
        }else{
            this.registFlg = 0;
        }
    }
    
    public int getUserID(){
        return this.userID;
    }
    public void getUserID(int userID){
        this.userID = userID;
    }
}
