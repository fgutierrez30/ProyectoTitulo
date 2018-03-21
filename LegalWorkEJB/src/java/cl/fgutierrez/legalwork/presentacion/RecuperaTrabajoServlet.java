/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.dto.TrabajoTpTrabajoClienteDTO;
import cl.fgutierrez.legalwork.entidades.Trabajo;
import cl.fgutierrez.legalwork.persistencia.TrabajoSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "RecuperaTrabajoServlet", urlPatterns = {"/recuperaTrabajoServlet","/getAllTrabajos"})
public class RecuperaTrabajoServlet extends HttpServlet {

    @EJB
    private TrabajoSessionBean objTrabajoSessionBean;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<TrabajoTpTrabajoClienteDTO> trabajosPen=this.objTrabajoSessionBean.TrabajosPendientes();
        sesion.setAttribute("listTrabajosPen", trabajosPen);
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  

}
