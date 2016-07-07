/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.bj;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author You
 */
public class Dealer extends Human {
    ArrayList<Integer> cards = new ArrayList<Integer>();
    //ArrayList<Integer> randOne = new ArrayList<Integer>();
    String mark[] = {"Heart","Dia","Spade","Club"};
    Random rand = new Random();
    int dealerSum = 0;    
        
    /*
    int heart[]={1,2,3,4,5,6,7,8,9,10,11,12,13},
        dia[]  ={1,2,3,4,5,6,7,8,9,10,11,12,13},    
        spade[]={1,2,3,4,5,6,7,8,9,10,11,12,13},
        club[] ={1,2,3,4,5,6,7,8,9,10,11,12,13};
    */
    public Dealer(){
        for(int i = 1; i <= 52; i++){
            cards.add(i);
        }
    }
    
    public ArrayList deal(){
        ArrayList<Integer> randTwo =new ArrayList<Integer>();
        for(int i = 0; i < 2 ; i++){
            randTwo.add(cards.get(rand.nextInt(cards.size())));
        }
        return randTwo;
    }
    
    public ArrayList hit(){
        ArrayList<Integer> randOne =new ArrayList<Integer>();
        if(randOne.isEmpty()){
            randOne.add(cards.get(rand.nextInt(cards.size())));
        }else{
            randOne.set(0, cards.get(rand.nextInt(cards.size())));
        }
        return randOne;
    }
    
    public int open(){
        return dealerSum;
    }
    
    public void setCard(ArrayList setCard){
        for(int i = 0; i < setCard.size();i++){
            myCards.add((Integer)setCard.get(i) /13);
            myCards.add(((Integer)setCard.get(i) %13) +1);
        }
    }

    public boolean checkSum(){
        int count = 0;
        dealerSum = 0;
        for(int i = 1; i < myCards.size(); i = i=i+2){
            if(myCards.get(i) == 1 && count == 0){ 
                dealerSum = dealerSum + 11;
                count = 1;
            }else if(myCards.get(i) > 10){
                dealerSum = dealerSum + 10;
            }else{
                dealerSum = dealerSum + myCards.get(i);
            }
        }
        return (dealerSum < 15);
    }
}
