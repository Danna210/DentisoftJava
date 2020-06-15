/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.cita;
import modelo.citagetset;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ServletActualizarCita", urlPatterns = {"/ServletActualizarCita"})
public class ServletActualizarCita extends HttpServlet {
      private String fec, codi, odo, hor, est;

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
        
        
            ArrayList<citagetset> lista=new ArrayList<>();
            String cod;
            cod=request.getParameter("cod");
            citagetset cit=new citagetset(cod);
            cita ci=new cita();
            lista=ci.consulCod(cod);
            
            if (lista.size()>0){
                for (int i=0; i<lista.size(); i++){
                    cit=lista.get(i);
                    fec=cit.getFec();
                    codi=cit.getCod();
                    odo=cit.getDod();
                    hor=cit.getHor();
                    est=cit.getEst();
                    
                }
            }
            
            
            
           
            HttpSession pac= request.getSession(true);
            pac.setAttribute("servletFechaCit", fec);
            pac.setAttribute("ServletCitCod", codi);
            pac.setAttribute("ServletCitOdo", odo);
            pac.setAttribute("ServletCitHor", hor);
            pac.setAttribute("ServletCitEst", est);
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
