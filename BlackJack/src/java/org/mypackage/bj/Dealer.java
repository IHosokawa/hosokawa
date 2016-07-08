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
    Random rand = new Random();
    int dealerSum = 0;    
        
    /*　ArrayList指定のため未使用
    int heart[]={1,2,3,4,5,6,7,8,9,10,11,12,13},
        dia[]  ={1,2,3,4,5,6,7,8,9,10,11,12,13},    
        spade[]={1,2,3,4,5,6,7,8,9,10,11,12,13},
        club[] ={1,2,3,4,5,6,7,8,9,10,11,12,13};
    */
    public Dealer(){
        //cardsへジョーカーを抜いた52枚のカードを持たせる
        for(int i = 1; i <= 52; i++){
            cards.add(i);
        }
    }
    
    public ArrayList deal(){
        ArrayList<Integer> randTwo =new ArrayList<Integer>();
        //cardsからランダムで種類の違う2枚のカードを返す
        do{
            for(int i = 0; i < 2 ; i++){
                randTwo.add(cards.get( rand.nextInt(cards.size()) ));
            }
        }while(randTwo.get(0).equals(randTwo.get(1)) ||
                randTwo.get(0).equals(99) ||        //ユーザー側処理時に99を引いたときに再度ループ
                randTwo.get(1).equals(99));
        
        //使用したカードの場所を99へ変更
        for(int i = 0; i < 2 ; i++){
            cards.set(randTwo.get(i)-1,99);
        }
        
        return randTwo;
    }
    
    public ArrayList hit(){
        ArrayList<Integer> randOne =new ArrayList<Integer>();
        //cardsからランダムで使用されていない1枚のカードを返す
        do{
            if(randOne.isEmpty()){  //返す値をひとつにする
                randOne.add(cards.get( rand.nextInt(cards.size()) ));
            }else{
                randOne.set(0, cards.get( rand.nextInt(cards.size()) ));
            }
        }while(randOne.get(0).equals(99));
        
        //使用したカードの場所を99へ変更
        cards.set(randOne.get(0)-1, 99);
        
        return randOne;
    }
    
    public int open(){
        return dealerSum;
    }
    
    //引いたカードを自分の手札に加える
    public void setCard(ArrayList setCard){
        for(int i = 0; i < setCard.size();i++){
            //0含む偶数番地にカードの種類判別
            myCards.add((Integer)setCard.get(i) /13);
            //奇数番地にカードの数字判別
            myCards.add(((Integer)setCard.get(i) %13) +1);
        }
    }

    public boolean checkSum(){
        dealerSum = 0;          //合計値の初期化
        for(int i = 1; i < myCards.size(); i = i+2){
            //所持カードに1があり、現在の合計値が11未満の場合
            if(myCards.get(i) == 1 && dealerSum < 11){ 
                dealerSum = dealerSum + 11;
            //所持カードに11以上のカードがある場合10ポイント追加
            }else if(myCards.get(i) > 10){
                dealerSum = dealerSum + 10;
            //それ以外は手札の数字をそのまま追加
            }else{
                dealerSum = dealerSum + myCards.get(i);
            }
        }
        return (dealerSum < 15);
    }
}
