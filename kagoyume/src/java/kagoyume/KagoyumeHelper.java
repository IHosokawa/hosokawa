/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

//import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

//import javax.servlet.http.HttpSession;

/**
 *
 * @author You
 */
public class KagoyumeHelper {
    private final String HomeURL = "index.jsp";
    private final String LoginURL = "Login";
    
    public static KagoyumeHelper getInstance(){
        return new KagoyumeHelper();
    }
    public String home(){
        return "<a href=\""+HomeURL+"\">トップへ戻る</a>";
    }
    
    public String login(String login){
        if(login.equals("li")){
            return "<a href=\"" + LoginURL + "\">ログイン</a>";
        }else{
            return "<a href=\"" + LoginURL + "\">ログアウト</a>";
        }
    }
    
    
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "ユーザー名";
                }
                if(val.equals("password")){
                    output +="パスワード";
                }
                if(val.equals("mail")){
                    output +="メールアドレス";
                }
                if(val.equals("address")){
                    output +="住所";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
}
