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
import javax.servlet.ServletContext;
import java.io.*;


/**
 *
 * @author You
 */
public class kiso8 extends HttpServlet {

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
        
        ServletContext app = this.getServletContext();
        /*
        File jibun = new File(app.getRealPath("jiko.txt"));
        FileWriter fw = new FileWriter(jibun,false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write("てすと");
        bw.newLine();
        bw.write("test");
        
        
        
        FileWriter fw = new FileWriter(app.getRealPath("jiko.txt"),true);
        PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
        
        pw.println("test");
        pw.println("てすと");
        
        pw.close();
        */
        
        File jibun = new File ("C:/Users/You/Desktop/hosokawa/JavaNomalClass/src/java/org/mypackage/nomal/jiko.txt");
        FileWriter fw = new FileWriter(jibun,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("test");
        bw.newLine();
        bw.write("てすと");
        bw.newLine();
        bw.close();
        
        try {
            out.print(app.getRealPath("jiko.txt"));
            /* TODO output your page here. You may use following sample code. */
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet kiso8</title>");            
            out.println("</head>");
            out.println("<body>");
            FileWriter fw = new FileWriter(app.getRealPath("jiko.txt"),false);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            fw.write("ttttttt");

            pw.println("test");
            pw.println("てすと");

            pw.close();
            */
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
