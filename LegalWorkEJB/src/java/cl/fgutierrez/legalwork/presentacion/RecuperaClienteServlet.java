
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.entidades.Cliente;
import cl.fgutierrez.legalwork.persistencia.ClienteSessionBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "RecuperaClienteServlet", urlPatterns = {"/recuperaClienteServlet","/getAllClient" })
public class RecuperaClienteServlet extends HttpServlet {

    @EJB
    private ClienteSessionBean objClienteSessionBean;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        List<Cliente>listaClientes=this.objClienteSessionBean.getAllCliente();
        session.setAttribute("listaCliente", listaClientes);
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        
        String rut_cli=request.getParameter("txtRut");
        String razon_social=request.getParameter("txtRazonSocial");
        int estado_cli=1;
        String email_cli=request.getParameter("txtEmail");
        String fono_cli=request.getParameter("txtFono");
        
        Cliente infoCliente=new Cliente(rut_cli, razon_social, estado_cli, email_cli, fono_cli);
          try{
            this.objClienteSessionBean.addCliente(infoCliente);
            response.sendRedirect("clientes.jsp");
        }catch(Exception ex){
            session.setAttribute("msgError", "Erro al guardar Cliente");
            response.sendRedirect("home.jsp");
        }
      
    }

}
