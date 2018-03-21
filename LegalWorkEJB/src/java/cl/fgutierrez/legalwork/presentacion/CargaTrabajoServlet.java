/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.dto.TrabajoDTO;
import cl.fgutierrez.legalwork.dto.TrabajoTpTrabajoClienteDTO;
import cl.fgutierrez.legalwork.entidades.Cliente;
import cl.fgutierrez.legalwork.persistencia.ClienteSessionBean;
import cl.fgutierrez.legalwork.persistencia.TipoTrabajoSessionBean;
import cl.fgutierrez.legalwork.persistencia.TrabajoSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CargaTrabajoServlet", urlPatterns = {"/cargaTrabajoServlet","/llenaTrabajo"})
public class CargaTrabajoServlet extends HttpServlet {
    
    @EJB
    private TrabajoSessionBean objTrabajoSessionBean;
    
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
         try{
         int id_tpTrabajo=Integer.parseInt(request.getParameter("cmbTpTrabajo"));
         DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         Date fecha_inicio=sdf.parse(request.getParameter("txtFechaInicio"));
         Date fecha_fin=sdf.parse(request.getParameter("txtFechaFin"));
         String estado="Sin Asignar";
         Date fecha_fin_real=null;
         String comentario=request.getParameter("txtDescripcion");
         String rut_cliente=request.getParameter("cmbCliente");
         
             TrabajoDTO infoTrabajoDTO=new TrabajoDTO(id_tpTrabajo, fecha_inicio, fecha_fin, estado, fecha_fin_real, comentario, rut_cliente);
             this.objTrabajoSessionBean.addTrabajo(infoTrabajoDTO);
             response.sendRedirect("nuevoTrabajo.jsp");
         
         }catch(Exception ex){
             
         }
         
         
    }

   


}
