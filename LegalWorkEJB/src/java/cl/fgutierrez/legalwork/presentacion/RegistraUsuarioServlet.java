/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.dto.UsuarioDTO;
import cl.fgutierrez.legalwork.entidades.Usuario;
import cl.fgutierrez.legalwork.persistencia.UsuarioSessionBean;
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
@WebServlet(name = "RegistraUsuarioServlet", urlPatterns = {"/registraUsuarioServlet","/registraUsuario"})
public class RegistraUsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        
        String rut_usr=request.getParameter("txtRut");
        String login_usr=request.getParameter("txtNomUsr");
        String pass_usr=request.getParameter("txtPass");
        String nom_usr=request.getParameter("txtNombre");
        String apell_usr=request.getParameter("txtApell");
        String email_usr=request.getParameter("txtEmail");
        String telef_usr=request.getParameter("txtFono");
        int estado_usr=1;
        int id_perfil=Integer.parseInt(request.getParameter("cmbPerfil"));
        UsuarioDTO objUsuarioDTO=new UsuarioDTO(rut_usr, login_usr, pass_usr, nom_usr, apell_usr, email_usr, telef_usr, estado_usr, id_perfil);
        
        try{
            this.objUsuarioSessionBean.addUsuario(objUsuarioDTO);
            response.sendRedirect("usuarios.jsp");
        }catch(Exception ex){
            sesion.setAttribute("msgError", "Erro al guardar Usuario");
            response.sendRedirect("home.jsp");
        }
    }

    

}
