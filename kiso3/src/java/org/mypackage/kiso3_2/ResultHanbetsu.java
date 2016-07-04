/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.kiso3_2;

import java.io.Serializable;
/**
 *
 * @author You
 */
public class ResultHanbetsu implements Serializable{
    private String modoriti;
    
    public ResultHanbetsu(){}
    
    public void setHikisuu(Integer hikisuuI){
        if(0 == (hikisuuI%2)){
            this.modoriti = "偶数";
        }else{
            this.modoriti = "奇数";
        }
    }
    public String getHikisuu(){
        return modoriti;
    }
}
