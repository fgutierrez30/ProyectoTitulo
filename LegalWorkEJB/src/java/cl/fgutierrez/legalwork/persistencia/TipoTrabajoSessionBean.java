/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.entidades.TipoTrabajo;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cetecom
 */
@Stateless
public class TipoTrabajoSessionBean {

    @PersistenceContext(unitName = "LegalWorkEJBPU")
    private EntityManager em;
    
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TipoTrabajo>getAllTipoTrabajo()
    {
        return em.createNamedQuery("TipoTrabajo.findAll", TipoTrabajo.class)
                 .getResultList();
    }
            
       
    public void addTpTrabajo(TipoTrabajo infoTpTrabajo)
    {
        em.persist(infoTpTrabajo);
    }
    
    public TipoTrabajo tpTrabajoXID(int idTpTrabajo)
    {
      TipoTrabajo tpTrabajo=em.createNamedQuery("TipoTrabajo.findByIdTipoTrabajo", TipoTrabajo.class)
                              .setParameter("idTipoTrabajo", idTpTrabajo)
                              .getSingleResult();
      return tpTrabajo;
    }
    
    
    
    
}
