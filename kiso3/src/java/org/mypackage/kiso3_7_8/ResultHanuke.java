/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.kiso3_7_8;

import java.io.Serializable;

/**
 *
 * @author You
 */
public class ResultHanuke implements Serializable {

        // ユーザー情報
    private String UserData[] = {"1","田中","2000.01.01","東京",
                                "2","佐藤","1990.02.02","千葉",
                                "3","鈴木","1995.03.03","神奈川",
                                "4","加藤","1985.04.04","埼玉"};
        // 該当IDのユーザー情報格納変数
    private String[] OutData = new String[3];
    
    public ResultHanuke(){}
    
    public void setIndex (String index){
        // ユーザー情報よりIDを検索
        for ( int i = 0;i < UserData.length; i = i + 4){
            // IDが一致した場合の処理
            if( index.equals(UserData[i]) ){
                // ID以外のユーザー情報をOutDataへ格納
                for (int j = 0;j < 3;j++){
                    this.OutData[j] = UserData[i+j+1];
                }
            }
        }
    }
    
    public String[] getIndex(){
        return UserData;
    }
    
}
