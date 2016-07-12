/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.nomal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.servlet.ServletContext;
import java.util.*;
//import java.lang.Math;

/**
 *
 * @author You
 */
public class ouyou extends HttpServlet {

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
        
        
        int a = 5,b = 2;
        
        
        ServletContext app = this.getServletContext();
        File logs = new File(app.getRealPath("log.txt"));
        
        Date nowtime = new Date();
        
        FileWriter startfw = new FileWriter(logs,true);
        BufferedWriter startbw = new BufferedWriter(startfw);
        SimpleDateFormat sdt = new SimpleDateFormat("dd日hh時mm分ss秒");
        
        startbw.write("<br>" + sdt.format(nowtime) + " 開始<br>");
        
        
        startbw.write("int a = " + a + ",b = " + b + "<br>");
        
        startbw.write("abs(a)" + Math.abs(a) +"<br>");
        startbw.write("max(a, b)" + Math.max(a, b) + "<br>");
        startbw.write("random()" + Math.random() + "<br>");
        startbw.close();
        
        
        FileWriter endfw = new FileWriter(logs,true);
        BufferedWriter endbw = new BufferedWriter(endfw);
        
        endbw.write(sdt.format(nowtime) + "終了");
        endbw.close();
        
        FileReader fr = new FileReader(logs);
        BufferedReader br = new BufferedReader(fr);
        String str;
        while((str = br.readLine())!=null){
            out.print(str);
        }
        br.close();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ouyou</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ouyou at " + request.getContextPath() + "</h1>");
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
