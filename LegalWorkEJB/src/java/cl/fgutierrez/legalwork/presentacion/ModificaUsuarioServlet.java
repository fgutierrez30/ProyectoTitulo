/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO;
import cl.fgutierrez.legalwork.persistencia.UsuarioSessionBean;
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
@WebServlet(name = "ModificaUsuarioServlet", urlPatterns = {"/modificaUsuarioServlet","/modificarUsuario"})
public class ModificaUsuarioServlet extends HttpServlet {
    
    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        int id_usr=Integer.parseInt(request.getParameter("codigoUsr"));
        
        try{
            UsuarioPerfilDTO infoUsuarioPerfil=this.objUsuarioSessionBean.buscaXID(id_usr);
            if(infoUsuarioPerfil!=null)
            {
                session.setAttribute("objetoAeditar", infoUsuarioPerfil);
                response.sendRedirect("usuarios.jsp");
            }else{
            response.sendRedirect("usuarios.jsp");
            }
        }catch(Exception ex)
        {
            
        }
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
