package apirestdelicias.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable {

    @Id
    @Column(name = "idmensaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmensaje;

    @ManyToOne
    @JoinColumn(name = "idusuario1", referencedColumnName = "idusuario")
    private Usuario idusuario1;

    @ManyToOne
    @JoinColumn(name = "idusuario2", referencedColumnName = "idusuario")
    private Usuario idusuario2;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha")
    private Date fecha;

    public Mensaje() {
    }

    public Mensaje(Integer idmensaje, Usuario idusuario1, Usuario idusuario2, String texto, Date fecha) {
        this.idmensaje = idmensaje;
        this.idusuario1 = idusuario1;
        this.idusuario2 = idusuario2;
        this.texto = texto;
        this.fecha = fecha;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Usuario getIdusuario1() {
        return idusuario1;
    }

    public void setIdusuario1(Usuario idusuario1) {
        this.idusuario1 = idusuario1;
    }

    public Usuario getIdusuario2() {
        return idusuario2;
    }

    public void setIdusuario2(Usuario idusuario2) {
        this.idusuario2 = idusuario2;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "idmensaje=" + idmensaje +
                ", idusuario1=" + idusuario1 +
                ", idusuario2=" + idusuario2 +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}