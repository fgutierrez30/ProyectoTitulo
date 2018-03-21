
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.entidades.Cliente;
import cl.fgutierrez.legalwork.persistencia.ClienteSessionBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ModificaClienteServlet", urlPatterns = {"/modificaClienteServlet","/actualizaCliente"})
public class ModificaClienteServlet extends HttpServlet {

    @EJB
    private ClienteSessionBean objClienteSessionBean;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        String rut_cliente=request.getParameter("rutCliente");
        try{
            Cliente  infoPerfil=this.objClienteSessionBean.buscarClienteXRut(rut_cliente);
            if(infoPerfil!=null){
             session.setAttribute("objetoAeditar", infoPerfil);
            response.sendRedirect("clientes.jsp");
            }else{
                session.setAttribute("msgError", "No hay nada para modificar");
                response.sendRedirect("clientes.jsp");
            }
        }catch(Exception ex){
            session.setAttribute("msgError", "No se pudo eliminar"+ ex.getMessage());
            response.sendRedirect("clientes.jsp");
        }
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          HttpSession session=request.getSession();
          
        String rut_client=request.getParameter("txtIdPerfil");
        String nuevo_nombre=request.getParameter("txtRazonSocAct");
        int nuevo_estado=1;
        String nuevo_correo=request.getParameter("txtEmailAct");
        String nuevo_fono=request.getParameter("txtFonoAct");
        
        
        
        try{
            Cliente  infoPerfil=this.objClienteSessionBean.buscarClienteXRut(rut_client);
            
            if(infoPerfil!=null){
                infoPerfil.setRazonSocial(nuevo_nombre);
                infoPerfil.setEstadoCliente(nuevo_estado);
                infoPerfil.setCorreoCliente(nuevo_correo);
                infoPerfil.setTelefCliente(nuevo_fono);
                this.objClienteSessionBean.updateCliente(infoPerfil);
            response.sendRedirect("clientes.jsp");
            }else{
                session.setAttribute("msgError", "No hay nada para modificar");
                response.sendRedirect("clientes.jsp");
            }
        }catch(Exception ex){
            session.setAttribute("msgError", "No se pudo eliminar"+ ex.getMessage());
            response.sendRedirect("clientes.jsp");
        }
        
        
        
        
    }


}
