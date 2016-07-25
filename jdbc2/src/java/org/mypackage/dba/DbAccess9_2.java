/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.dba;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author You
 */
public class DbAccess9_2 extends HttpServlet {

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
        
        //DB接続
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        //値受け取り
        String id = request.getParameter("profilesID");
        String name = request.getParameter("name");
        String tell = request.getParameter("tell");
        String age = request.getParameter("age");
        String birth = request.getParameter("birthday");
        //String型をInt型へ
        Integer idi = Integer.parseInt(id);
        Integer agei = Integer.parseInt(age);
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","hosokawa","hosokawa");
            db_st = db_con.prepareStatement("select * from profiles");
            db_st.executeUpdate("insert into profiles values (?,?,?,?,?)");
            db_st.setInt(1, idi);
            db_st.setString(2, name);
            db_st.setString(3, tell);
            db_st.setInt(4,agei);
            db_st.setString(5, birth);
            
            db_data = db_st.executeQuery();
            while(db_data.next()){
                out.println("ID     :" + db_data.getInt("profilesID") + "<br>");
                out.println("名前    :" + db_data.getString("name") + "<br>");
                out.println("電話番号:" + db_data.getString("tell") + "<br>");
                out.println("年齢    :" + db_data.getInt("age") + "<br>");
                out.println("生年月日:" + db_data.getDate("birthday") + "<br>");
            }
        }catch (SQLException sql_e){
            out.println("errer1:"+sql_e.toString());
        }catch (Exception e){
            out.println("errer2:" + e.toString());
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
