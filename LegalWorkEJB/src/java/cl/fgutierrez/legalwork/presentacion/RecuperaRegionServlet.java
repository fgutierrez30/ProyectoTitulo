
package cl.fgutierrez.legalwork.presentacion;

import cl.fgutierrez.legalwork.entidades.Region;
import cl.fgutierrez.legalwork.persistencia.RegionSessionBean;
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


@WebServlet(name = "RecuperaRegionServlet", urlPatterns = {"/recuperaRegionServlet","/getAllRegion"})
public class RecuperaRegionServlet extends HttpServlet {
    
    @EJB
    private RegionSessionBean objRegionSessionBean;

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<Region> listaRegion=this.objRegionSessionBean.getAllRegion();
        sesion.setAttribute("listaRegiones", listaRegion);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  

}
