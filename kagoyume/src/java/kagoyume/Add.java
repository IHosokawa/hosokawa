/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.util.ArrayList;
/**
 *
 * @author You
 */
public class Add extends HttpServlet {

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
        //リクエストパラメータの文字コードをUTF-8に変更
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        
        try {
            String detailID = (String)session.getAttribute("DetailId");
            SearchData sd = null;
            if(session.getAttribute("Coming").equals("search")){
                ArrayList al = (ArrayList)session.getAttribute("ResultData");
                for(int i = 0; i < al.size(); i++){
                    sd = (SearchData)al.get(i);
                    if(sd.getItemCode().equals(detailID)){
                        break;
                    }
                }
            }else if( session.getAttribute("Coming").equals("cart")){
                ArrayList al = (ArrayList)session.getAttribute("Cart");
                for(int i = 0; i < al.size(); i++){
                    sd = (SearchData)al.get(i);
                    if(sd.getItemCode().equals(detailID)){
                        break;
                    }
                }
            }
            ArrayList<SearchData> cart = new ArrayList<SearchData>();

            //アイテムページの情報をセッションに格納
            if(session.getAttribute("Cart") == null){                           //カートに何も入っていないならそのまま格納
                cart.add(sd);
                session.setAttribute("Cart", cart);
            }else{
                cart = (ArrayList)session.getAttribute("Cart");                 //セッションから内容を取り出して
                cart.add(sd);                                                   //新しく追加したデータをArrayListへ格納
                session.setAttribute("Cart", cart);                             //改めてセッションに格納
            }
            
                
            
            request.getRequestDispatcher("/add.jsp").forward(request, response);
        }catch(Exception e){
            out.println("error" + e.getMessage());
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
