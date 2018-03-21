
package cl.fgutierrez.legalwork.dto;

import java.io.Serializable;
import java.util.Date;


public class TrabajoDTO implements Serializable{
    
    private int id_trabajo;
    private int id_tpTrabajo;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String estado;
    private Date fecha_fin_real;
    private String comentario;
    private String rut_cliente;

    public TrabajoDTO() {
    }

    public TrabajoDTO(int id_trabajo, int id_tpTrabajo, Date fecha_inicio, Date fecha_fin, String estado, Date fecha_fin_real, String comentario, String rut_cliente) {
        this.id_trabajo = id_trabajo;
        this.id_tpTrabajo = id_tpTrabajo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.fecha_fin_real = fecha_fin_real;
        this.comentario = comentario;
        this.rut_cliente = rut_cliente;
    }

    public TrabajoDTO(int id_tpTrabajo, Date fecha_inicio, Date fecha_fin, String estado, Date fecha_fin_real, String comentario, String rut_cliente) {
        this.id_tpTrabajo = id_tpTrabajo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.fecha_fin_real = fecha_fin_real;
        this.comentario = comentario;
        this.rut_cliente = rut_cliente;
    }

    public int getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(int id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public int getId_tpTrabajo() {
        return id_tpTrabajo;
    }

    public void setId_tpTrabajo(int id_tpTrabajo) {
        this.id_tpTrabajo = id_tpTrabajo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_fin_real() {
        return fecha_fin_real;
    }

    public void setFecha_fin_real(Date fecha_fin_real) {
        this.fecha_fin_real = fecha_fin_real;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }
    
    
    
    
    
}
