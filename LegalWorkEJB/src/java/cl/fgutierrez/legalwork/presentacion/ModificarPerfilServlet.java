/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.entidades.Perfil;
import cl.fgutierrez.legalwork.persistencia.PerfilSessionBean;
import java.io.IOException;
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
@WebServlet(name = "ModificarPerfilServlet", urlPatterns = {"/modificarPerfilServlet","/modificarPerfil"})
public class ModificarPerfilServlet extends HttpServlet {

    @EJB
    private PerfilSessionBean objPerfilSessionBean;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        int idPerfil=Integer.parseInt(request.getParameter("id_perfil"));
        try{
            Perfil  infoPerfil=this.objPerfilSessionBean.buscarPerfilXCodigo(idPerfil);
            if(infoPerfil!=null){
                session.setAttribute("objetoAeditar", infoPerfil);
            response.sendRedirect("perfiles.jsp");
            }else{
                session.setAttribute("msgError", "No hay nada para modificar");
                response.sendRedirect("perfiles.jsp");
            }
        }catch(Exception ex){
            session.setAttribute("msgError", "No se pudo eliminar"+ ex.getMessage());
            response.sendRedirect("perfiles.jsp");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session=request.getSession();
        int idPerfil=Integer.parseInt(request.getParameter("txtIdPerfil"));
        String nuevoNombre=request.getParameter("txtNuevoNombre");
        try{
            Perfil  infoPerfil=this.objPerfilSessionBean.buscarPerfilXCodigo(idPerfil);
            
            if(infoPerfil!=null){
                infoPerfil.setNomPerfil(nuevoNombre);
                this.objPerfilSessionBean.updatePerfil(infoPerfil);
            response.sendRedirect("perfiles.jsp");
            }else{
                session.setAttribute("msgError", "No hay nada para modificar");
                response.sendRedirect("perfiles.jsp");
            }
        }catch(Exception ex){
            session.setAttribute("msgError", "No se pudo eliminar"+ ex.getMessage());
            response.sendRedirect("perfiles.jsp");
        }
        
    }

    

}
