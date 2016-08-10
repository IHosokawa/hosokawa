/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

/**
 *
 * @author You
 * 商品データを受け取るクラス
 */

public class SearchData {
    
    private String searchName;
    private int searchSum;
    private String name;
    private String uri;
    private int price;
    private String itemCode;
    private String description;
    private double reviewRate;
    private int reviewCount;
    
    public void SearchData(){}
    
    public String getSearchName(){
        return this.searchName;
    }
    public void setSearchName(String name){
        if(name != null){
            this.searchName = name;
        }else{
            this.searchName = "";
        }
    }
    
    public int getSearchSum(){
        return this.searchSum;
    }
    public void setSearchSum(String sum){
        if(sum != null){
            this.searchSum = Integer.parseInt(sum);
        }else{
            this.searchSum = 0;
        }
    }
    
    public String getName(){
        
        return this.name;
    }
    public void setName(String name){
        if(name != null){
            this.name = name;
        }else{
            this.name = "";
        }
    }
    
    public String getUri(){
        return this.uri;
    }
    public void setUri(String uri){
        if(uri != null){
            this.uri = uri;
        }else{
            this.uri = "";
        }
    }
    
    public int getPrice(){
        return price;
    }
    public void setPrice(String price){
        if(price != null){
            this.price = Integer.parseInt(price);
        }else{
            this.price = 0;
        }
    }
    
    public String getItemCode(){
        return this.itemCode;
    }
    public void setItemCode(String itemCode){
        if(itemCode != null){
            this.itemCode = itemCode;
        }else{
            this.itemCode = "";
        }
    }
    
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        if(description != null){
            this.description = description;
        }else{
            this.description = "";
        }
    }
    
    public double getReviewRate(){
        return this.reviewRate;
    }
    public void setReviewRate(String reviewRate){
        if( reviewRate != null ){
            this.reviewRate = Double.parseDouble(reviewRate);
        }else{
            this.reviewRate = 0.0;
        }
    }
    
    public int getReviewCount(){
        return this.reviewCount;
    }
    public void setReviewCount(String reviewCount){
        if( reviewCount != null ){
            this.reviewCount = Integer.parseInt(reviewCount);
        }else{
            this.reviewCount = 0;
        }
    }
}
