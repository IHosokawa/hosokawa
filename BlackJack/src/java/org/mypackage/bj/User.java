/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.bj;

import java.util.ArrayList;

/**
 *
 * @author You
 */
public class User extends Human {
    int userSum = 0;
    public int open(){
        return userSum;
    }
    
    public void setCard(ArrayList setCard){
        for(int i = 0; i < setCard.size();i++){
            myCards.add((Integer)setCard.get(i)/13);
            myCards.add(((Integer)setCard.get(i)%13)+1);
        }
    }
    public boolean checkSum(){
        userSum = 0;
        for(int i = 1; i < myCards.size(); i = i+2){
            if(myCards.get(i) == 1 &&  userSum < 11){ 
                userSum = userSum + 11;
            }else if(myCards.get(i) > 10){
                userSum = userSum + 10;
            }else{
                userSum = userSum + myCards.get(i);
            }
        }
        return (userSum < 15);
    }
}
