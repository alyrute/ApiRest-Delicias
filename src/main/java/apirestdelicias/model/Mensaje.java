package apirestdelicias.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable {

    @Id
    @Column(name = "idmensaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmensaje;

    @Column(name = "senderid")
    private Integer senderid;

    @Column(name = "receiverid")
    private Integer receiverid;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "leido")
    private boolean leido;
    @Column(name = "idproducto")
    private Integer idproducto;

    public Mensaje() {
    }

    public Mensaje(Integer idmensaje, Integer senderid, Integer receiverid, String texto, String fecha, boolean leido , Integer idproducto) {
        this.idmensaje = idmensaje;
        this.senderid = senderid;
        this.receiverid = receiverid;
        this.texto = texto;
        this.fecha = fecha;
        this.leido = leido;
        this.idproducto = idproducto;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "idmensaje=" + idmensaje +
                ", senderid=" + senderid +
                ", receiverid=" + receiverid +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                ", leido=" + leido +
                ", idproducto=" + idproducto +
                '}';
    }
}