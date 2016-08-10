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

/**
 *
 * @author You
 */
public class DbAccess11_2 extends HttpServlet {

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
        String profID = request.getParameter("profilesID");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","hosokawa","hosokawa");
            ps = con.prepareStatement("SELECT * FROM profiles WHERE profilesID=?");
            ps.setInt(1, Integer.parseInt(profID));
            rs = ps.executeQuery();
            rs.next();
            
            //検索用にprofilesIDを保持
            request.setAttribute("profID", profID);
            //データベースから受け取ったデータをrequest形式で格納
            request.setAttribute("name", rs.getString("name"));
            request.setAttribute("tell", rs.getString("tell"));
            request.setAttribute("age", rs.getInt("age"));
            request.setAttribute("year", Integer.parseInt(new SimpleDateFormat("yyyy").format(rs.getDate("birthday"))));
            request.setAttribute("month", Integer.parseInt(new SimpleDateFormat("MM").format(rs.getDate("birthday"))));
            request.setAttribute("day", Integer.parseInt(new SimpleDateFormat("dd").format(rs.getDate("birthday"))));
            con.close();
            ps.close();
            rs.close();
            
            request.getRequestDispatcher("/DbAccess11.jsp").forward(request, response);
            
            
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
