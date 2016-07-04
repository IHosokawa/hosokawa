/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.kiso3_3;

import java.io.*;

/**
 *
 * @author You
 */
public class ResultMethod3tu implements Serializable{
    
    private Integer ret;
    
    public ResultMethod3tu(){}
    
    public Integer getD(){
        return ret;
    }
    
    void setD(Integer hiki,Integer five,boolean a){
        if (a == false){
            this.ret = hiki * five;
        }else{
            this.ret = (hiki * five)*(hiki * five);
        }
    }
}
