/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;


import cl.fgutierrez.legalwork.dto.ComunaDTO;
import cl.fgutierrez.legalwork.persistencia.ComunaSessionBean;
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
@WebServlet(name = "RecuperaComunaServlet", urlPatterns = {"/recuperaComunaServlet","/getAllComuna"})
public class RecuperaComunaServlet extends HttpServlet {

    @EJB
    private ComunaSessionBean objComunaSessionBean;
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        
        String nom_comuna=request.getParameter("txtNomComuna");
        int id_ciudad=Integer.parseInt(request.getParameter("cmbCiudad"));
        
        ComunaDTO infoComunaDTO=new ComunaDTO(nom_comuna, id_ciudad);
        
           try{
            this.objComunaSessionBean.addComuna(infoComunaDTO);
            response.sendRedirect("ProvinciasComunas.jsp");
        }catch(Exception ex){
            sesion.setAttribute("msgError", "Erro al guardar Ccomuna");
            response.sendRedirect("home.jsp");
        }
        
    }


}
