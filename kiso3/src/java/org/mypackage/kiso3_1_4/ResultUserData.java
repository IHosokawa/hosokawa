/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.kiso3_1_4;

import java.io.Serializable;
/**
 *
 * @author You
 */
public class ResultUserData implements Serializable{
    
    private String[] user;
    private Integer i;
    //課題4追記
    private boolean a;
    
    public ResultUserData() {}
    
    public String[] getUser(){
        return user;
    }
    
    public void setUser(String[] user){
        this.user = user;
        
    }
    
    public boolean isI(){
        return a;
    }
    
    public void setI(Integer index){
        this.i = index;
        if(i != 0){
            a = true;
        }else{
            a = false;
        }
    }
    
}
