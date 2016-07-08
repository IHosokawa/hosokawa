/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.bj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author You
 */
public class outCheck extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Dealer dealer = new Dealer();
        User user = new User();
        ArrayList<Integer> dealerArray = new ArrayList<Integer>();
        ArrayList<Integer> userArray = new ArrayList<Integer>();
        int dealerSum = 0, userSum = 0;
        
        //ディーラーのカード処理
        dealer.setCard(dealer.deal());
        while(dealer.checkSum()){
            dealer.setCard(dealer.hit());
        }
        
        //ユーザーのカード処理
        user.setCard(dealer.deal());
        while(user.checkSum()){
            user.setCard(dealer.hit());
        }
        
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet outCheck</title>");            
            out.println("</head>");
            out.println("ユーザー:");
            for(int i = 0; i < user.myCards.size();i++){
                if(((i+2)%2)==0){
                    switch(user.myCards.get(i)){
                        case 0:
                            out.print("Heart");
                            break;
                        case 1:
                            out.print("Dia");
                            break;
                        case 2:
                            out.print("Spade");
                            break;
                        case 3:
                            out.print("Culb");
                            break;
                        case 4:
                            out.print("Culb");
                            break;
                        default:
                            out.print("errer");
                    }
                } else {
                    out.println(user.myCards.get(i) + " ");
                }
            }
            out.println("合計"+ user.userSum +"<br>");
            
            out.println("<br>ディーラー:");
            for(int i = 0; i < dealer.myCards.size();i++){
                if(((i+2)%2)==0){
                    switch(dealer.myCards.get(i)){
                        case 0:
                            out.print("Heart");
                            break;
                        case 1:
                            out.print("Dia");
                            break;
                        case 2:
                            out.print("Spade");
                            break;
                        case 3:
                            out.print("Culb");
                            break;
                        case 4:
                            out.print("Culb");
                            break;
                        default:
                            out.print("errer");
                    }
                } else {
                    out.println(dealer.myCards.get(i) + " ");
                }
            }
            
            out.println("合計"+ dealer.dealerSum +"<br>");
            if( dealer.open() == user.open() ||
                    dealer.open() > 21 && user.open() > 21){
                out.println("引き分けです。");
            }else if( user.open() > 21 ||
                    dealer.open() < 22 &&
                    dealer.open() > user.open() ){
                out.println("ディーラーの勝利です。");
            }else{
                out.println("ユーザーの勝利です。");
            }
            out.println("<body>");
            out.println("<h1>Servlet outCheck at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
