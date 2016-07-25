/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;

/**
 *
 * @author You
 */
public class UserDataBeans implements Serializable{
    
    private String name;
    private int year;
    private int month;
    private int day;
    private int type;
    private String tell;
    private String comment;
    
    public UserDataBeans(){}
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(String year){
        this.year = Integer.parseInt(year);
    }
    
    public int getMonth(){
        return month;
    }
    
    public void setMonth(String month){
        this.month = Integer.parseInt(month);
    }
    public int getDay(){
        return day;
    }
    
    public void setDay(String day){
        this.day = Integer.parseInt(day);
    }
    public int getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = Integer.parseInt(type);
    }
    public String getTell(){
        return tell;
    }
    
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getComment(){
        return comment;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
}
