/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanPersona;
import com.entidades.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bianca_Valentina
 */
public class Ms_Servlet extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ms_Servlet_aplicacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ms_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    // aqui se encuentra el get que me muestra la infromacion
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         
         JavaBeanPersona ob2_jdp= new JavaBeanPersona();
         
         List<Persona> ob_lista_per = ob2_jdp.buscar_todos();
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ms_Servlet_aplicacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
                out.println("<th> Especialidad</th>");
            
                out.println("<th>Nombre</th>");
            
            out.println("</tr>");
            
            for(Persona ob_per: ob_lista_per){
                out.println("<tr>");
                out.println("<td>" +ob_per.getEspecialidad()+"</td>");
                
                out.println("<td>" +ob_per.getNombreApellido()+"</td>");
                out.println("</tr>");
                
            }
             out.println("</table>");    
           
            out.println("</body>");
            out.println("</html>");
        }

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
    //aqui se ecuentra el post q me oculta la informacion
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String identificacion = request.getParameter("Identificacion");
        String nombre = request.getParameter("Nombre");
        
        
        Persona ob_per= new Persona();
        ob_per.setNombreApellido(nombre);
        ob_per.setEspecialidad(identificacion);
        
        //controlador
        JavaBeanPersona ob_jbper= new JavaBeanPersona();
        ob_jbper.guardar(ob_per);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ms_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Usuario guardado corrctamente</h1>");
             out.println("<h1>Gracis por usar servlet</h1>");
           
            out.println("</body>");
            out.println("</html>");
        }
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
