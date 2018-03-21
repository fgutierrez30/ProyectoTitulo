/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.dto.MenuDTO;
import cl.fgutierrez.legalwork.dto.MenuPerfilDTO;
import cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO;
import cl.fgutierrez.legalwork.persistencia.MenuSessionBean;
import cl.fgutierrez.legalwork.persistencia.UsuarioSessionBean;
import java.io.IOException;
import java.util.LinkedList;
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
@WebServlet(name = "ValidarUsuarioServlet", urlPatterns = {"/validarUsuarioServlet","/validarUsuario"})
public class ValidarUsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioSessionBean objUsrSessionBean;
    
    @EJB
    private MenuSessionBean objMenuSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion=request.getSession();
        String login=request.getParameter("txblogin");
        String pass=request.getParameter("txbpass");
        UsuarioPerfilDTO usrPerfilDTO=this.objUsrSessionBean.UsuarioValidaLogin(login, pass);
        if(usrPerfilDTO!=null)
        {
            List<MenuPerfilDTO> listaMenuPerfilDTO=this.objMenuSessionBean.listadoMenuXPerfil(usrPerfilDTO.getPerfil().getIdPerfil());
            List<MenuDTO>listadoMenuDTO = cargarMenuDTO(listaMenuPerfilDTO);
            sesion.setAttribute("usuarioConectado",usrPerfilDTO);
            sesion.setAttribute("ListadoMenu", listadoMenuDTO);
            response.sendRedirect("home.jsp");
        }else{
            sesion.setAttribute("msgError", "Usuario no existe");
            response.sendRedirect("login.jsp");
        }
        
    }

    private List<MenuDTO> cargarMenuDTO(List<MenuPerfilDTO> listaMenuPerfilDTO) {
        
        List<MenuDTO>listadoMenu= new LinkedList<>();
        for(MenuPerfilDTO menu: listaMenuPerfilDTO)
        {
            MenuDTO infoMenuDTO= new MenuDTO(menu.getObjMenu().getIdMenu(), menu.getObjMenu().getNomMenu(), menu.getObjMenu().getPadreMenu(), menu.getObjMenu().getUrlMenu(), menu.getObjMenu().getIdMenu());
            listadoMenu.add(infoMenuDTO);
        }
        return listadoMenu;
    }


}
