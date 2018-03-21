/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.entidades.Perfil;
import cl.fgutierrez.legalwork.persistencia.PerfilSessionBean;
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
 * @author Felipe
 */
@WebServlet(name = "RecuperaPerfilServlet", urlPatterns = {"/recuperaPerfilServlet","/getAllPerfiles"})
public class RecuperaPerfilServlet extends HttpServlet {

    @EJB
    private PerfilSessionBean objPerfilSessionBean;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<Perfil>listadoPerfiles=this.objPerfilSessionBean.getAllPerfil();
        sesion.setAttribute("listaPerfiles", listadoPerfiles);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   }
