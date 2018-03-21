/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.entidades.TipoTrabajo;
import cl.fgutierrez.legalwork.persistencia.TipoTrabajoSessionBean;
import java.io.IOException;
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
 * @author cetecom
 */
@WebServlet(name = "RecuperaTipoTrabajoServlet", urlPatterns = {"/recuperaTipoTrabajoServlet","/getAllTpTrabajo"})
public class RecuperaTipoTrabajoServlet extends HttpServlet {

   @EJB
   private TipoTrabajoSessionBean objTpTrabajoSessionBean;
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<TipoTrabajo>listaTpTrabajo=this.objTpTrabajoSessionBean.getAllTipoTrabajo();
        sesion.setAttribute("listaTpTrabajo", listaTpTrabajo);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomTpTrabjo=request.getParameter("txtTipoTrabajo");
        TipoTrabajo infoTpTrabajo=new TipoTrabajo();
        infoTpTrabajo.setNomTipoTrabajo(nomTpTrabjo);
        this.objTpTrabajoSessionBean.addTpTrabajo(infoTpTrabajo);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        response.sendRedirect("tiposTrabajo.jsp");
        
        
    }

  
}
