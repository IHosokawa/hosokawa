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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author You
 */
public class ResultDbAccess11_2 extends HttpServlet {

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
        
        request.setCharacterEncoding("UTF-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String a = request.getParameter("name");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","hosokawa","hosokawa");
            ps = con.prepareStatement("UPDATE profiles SET name=?,tell=?,age=?,birthday=? WHERE profilesID=?");
            ps.setString(1, request.getParameter("name"));
            ps.setString(2, request.getParameter("tell"));
            ps.setInt(3, Integer.parseInt(request.getParameter("age")));
            int year = Integer.parseInt(request.getParameter("year"));
            int month = Integer.parseInt(request.getParameter("month"))-1;
            int day = Integer.parseInt(request.getParameter("day"));
            Calendar cal = Calendar.getInstance();
            cal.set(year,month,day);
            Date calpast = cal.getTime();
            ps.setDate(4, new java.sql.Date(calpast.getTime()));
            ps.setInt(5, Integer.parseInt(request.getParameter("profID")));
            ps.executeUpdate();
            out.println("Updated!!");
        }catch (SQLException sql_e){
            out.println("sql error:"+sql_e.getMessage());
        }catch (Exception e){
            out.println("error:"+e.getMessage());
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
