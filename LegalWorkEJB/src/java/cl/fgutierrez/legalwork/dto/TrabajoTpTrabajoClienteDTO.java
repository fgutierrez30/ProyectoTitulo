
package cl.fgutierrez.legalwork.dto;

import cl.fgutierrez.legalwork.entidades.Cliente;
import cl.fgutierrez.legalwork.entidades.TipoTrabajo;
import cl.fgutierrez.legalwork.entidades.Trabajo;
import java.io.Serializable;


public class TrabajoTpTrabajoClienteDTO implements Serializable{
    
    private Trabajo trabajo;
    private TipoTrabajo tpTrabajo;
    private Cliente cliente;

    public TrabajoTpTrabajoClienteDTO() {
    }

    public TrabajoTpTrabajoClienteDTO(Trabajo trabajo, TipoTrabajo tpTrabajo, Cliente cliente) {
        this.trabajo = trabajo;
        this.tpTrabajo = tpTrabajo;
        this.cliente = cliente;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public TipoTrabajo getTpTrabajo() {
        return tpTrabajo;
    }

    public void setTpTrabajo(TipoTrabajo tpTrabajo) {
        this.tpTrabajo = tpTrabajo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
