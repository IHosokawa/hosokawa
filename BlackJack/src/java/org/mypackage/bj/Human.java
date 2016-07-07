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
abstract public class Human {

    public void Human(){}
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    abstract public int open();
    abstract public void setCard(ArrayList setCard);
    abstract public boolean checkSum();
    
}