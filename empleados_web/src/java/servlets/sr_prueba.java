/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JLME
 */
public class sr_prueba extends HttpServlet {

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
            Estudiante obj_estudiante=new Estudiante();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_prueba</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            if (request.getParameter("btn_modificar")!= null) {
               //MODIFICAR
                obj_estudiante.setCarne(request.getParameter("txt_carne"));
                obj_estudiante.setNombres(request.getParameter("txt_nombres"));
                obj_estudiante.setApellidos(request.getParameter("txt_apellidos"));
                obj_estudiante.setDireccion(request.getParameter("txt_direccion"));
                obj_estudiante.setTelefono(request.getParameter("txt_telefono"));
                obj_estudiante.setCorreo(request.getParameter("txt_correo"));
                obj_estudiante.setFecha_nacimiento(request.getParameter("txt_fn"));
                obj_estudiante.setId_tipoSangre(Integer.parseInt(request.getParameter("drop_sangre")));
                obj_estudiante.setId_estudiante(Integer.parseInt(request.getParameter("txt_id")));
                obj_estudiante.modificar();
//                out.println("<h1>MODIFICACIÓN EXITOSA!!</h1>");
//                out.println("<a href='index.jsp'>Regresar<--</a>");
                response.sendRedirect("index.jsp");
                
            } 
            
            String act1 = request.getParameter("btn_eliminar");
            if (act1 == null) {
             } 
            else if (act1.equals("Eliminar")) {
               //ELIMINAR
                obj_estudiante.setId_estudiante(Integer.parseInt(request.getParameter("txt_id")));
                obj_estudiante.eliminar();
//                out.println("<h1>ELIMINACIÓN EXITOSA!!</h1>");
//                out.println("<a href='index.jsp'>Regresar<--</a>");
                response.sendRedirect("index.jsp");
            } 
            
        String act2 = request.getParameter("btn_agregar");
            if (act2 == null) {
             } 
            else if (act2.equals("Agregar")) {
                //AGREGAR
                obj_estudiante.setCarne(request.getParameter("txt_carne"));
                obj_estudiante.setNombres(request.getParameter("txt_nombres"));
                obj_estudiante.setApellidos(request.getParameter("txt_apellidos"));
                obj_estudiante.setDireccion(request.getParameter("txt_direccion"));
                obj_estudiante.setTelefono(request.getParameter("txt_telefono"));
                obj_estudiante.setCorreo(request.getParameter("txt_correo"));
                obj_estudiante.setFecha_nacimiento(request.getParameter("txt_fn"));
                obj_estudiante.setId_tipoSangre(Integer.parseInt(request.getParameter("drop_sangre")));
               if (obj_estudiante.insertar() >0){
//                   out.println("<h1>INGRESO EXITOSO!!</h1>");
//                   out.println("<a href='index.jsp'>Regresar<--</a>");
                   response.sendRedirect("index.jsp");
               }    
               else
               {
                    out.println("<h1>ERROR,Registro No Ingresado!!</h1>");
               }
                
            } 


               
            
             
            
           
       
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
