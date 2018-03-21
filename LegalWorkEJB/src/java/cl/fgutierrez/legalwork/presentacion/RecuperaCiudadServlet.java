/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.dto.CiudadDTO;
import cl.fgutierrez.legalwork.entidades.Ciudad;
import cl.fgutierrez.legalwork.persistencia.CiudadSessionBean;
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


@WebServlet(name = "RecuperaCiudadServlet", urlPatterns = {"/recuperaCiudadServlet","/getAllCiudades"})
public class RecuperaCiudadServlet extends HttpServlet {

    @EJB
    private CiudadSessionBean objCiudadSessionBean;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<Ciudad> listaCiudad=this.objCiudadSessionBean.getAllCiudad();
        sesion.setAttribute("listarCiudades", listaCiudad);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        
        String nom_ciudad=request.getParameter("txtNomCiudad");
        int cod_region=Integer.parseInt(request.getParameter("cmbRegion"));
        CiudadDTO infoCiudadDTO = new CiudadDTO(nom_ciudad, cod_region);
           try{
            this.objCiudadSessionBean.addCiudad(infoCiudadDTO);
            response.sendRedirect("ProvinciasComunas.jsp");
        }catch(Exception ex){
            sesion.setAttribute("msgError", "Erro al guardar Ciudad");
            response.sendRedirect("home.jsp");
        }
        
    }

}
