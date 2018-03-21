/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.entidades.Perfil;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class PerfilSessionBean {

    @PersistenceContext(unitName = "LegalWorkEJBPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Perfil>getAllPerfil()
    {
        return em.createNamedQuery("Perfil.findAll",Perfil.class)
                 .getResultList();
    }
    
    public Perfil buscarPerfilXCodigo(int codigo)
    {
        Perfil infoPerfil=null;
        try{
            infoPerfil=em.createNamedQuery("Perfil.findByIdPerfil",Perfil.class)
                         .setParameter("idPerfil", codigo)
                         .getSingleResult();
            
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoPerfil;
    }
    
    public void addPerfil(Perfil infoPerfil) throws ControladorExceptions
    {
        em.persist(infoPerfil);
    }
    
    
    public void updatePerfil(Perfil infoPerfil) throws ControladorExceptions
    {
        em.merge(infoPerfil);
    }
    
    
}
