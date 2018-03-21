/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.dto.UsuarioDTO;
import cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO;
import cl.fgutierrez.legalwork.entidades.Perfil;
import cl.fgutierrez.legalwork.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class UsuarioSessionBean {

   @PersistenceContext(unitName = "LegalWorkEJBPU")
   
   private EntityManager em;
   
   public UsuarioPerfilDTO UsuarioValidaLogin(String login,String pass)
   {
       UsuarioPerfilDTO infoUsr=null;
       try{
           infoUsr=em.createNamedQuery("Usuario.valida",UsuarioPerfilDTO.class).setParameter("loginUsr",login).setParameter("passUsr",pass).getSingleResult();
           
       }catch(NoResultException ex){
           return null;
       }catch(NonUniqueResultException ex){
           throw ex;
       }
       return infoUsr;
   }
   
   public void addUsuario(UsuarioDTO usuarioDTO)throws ControladorExceptions
   {
       Usuario infoUsuario=new Usuario();
       infoUsuario.setRutUsr(usuarioDTO.getRut_usr());
       infoUsuario.setLoginUsr(usuarioDTO.getLogin_usr());
       infoUsuario.setPassUsr(usuarioDTO.getPass_usr());
       infoUsuario.setNomUsr(usuarioDTO.getNom_usr());
       infoUsuario.setApellUsr(usuarioDTO.getApell_usr());
       infoUsuario.setEmailUsr(usuarioDTO.getEmail_usr());
       infoUsuario.setTelefUsr(usuarioDTO.getTelef_usr());
       infoUsuario.setEstadoUsr(usuarioDTO.getEstado_usr());
       Perfil infoPerfil=em.find(Perfil.class, usuarioDTO.getId_perfil());
       infoUsuario.setIdPerfil(infoPerfil);
       em.persist(infoUsuario);
   }
   
   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public List<UsuarioPerfilDTO>getAllUsuarios()
   {
       return em.createNamedQuery("Usuario.listado",UsuarioPerfilDTO.class)
               .getResultList();
   }
   
   
   public UsuarioPerfilDTO buscaXID(int idUsr)
   {
       return em.createNamedQuery("Usuario.modifica",UsuarioPerfilDTO.class).setParameter("idUsr", idUsr)
                .getSingleResult();
   }
   
   public void updateUsuario(UsuarioPerfilDTO infoUsuarioPerfil) throws ControladorExceptions
   {
       em.merge(infoUsuarioPerfil);
   }
   
}
