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
    @JoinColumn(name = "senderid", referencedColumnName = "idusuario")
    private Usuario senderid;

    @ManyToOne
    @JoinColumn(name = "receiverid", referencedColumnName = "idusuario")
    private Usuario receiverid;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "leido")
    private boolean leido;

    public Mensaje() {
    }

    public Mensaje(Integer idmensaje, Usuario senderid, Usuario receiverid, String texto, Date fecha, boolean leido) {
        this.idmensaje = idmensaje;
        this.senderid = senderid;
        this.receiverid = receiverid;
        this.texto = texto;
        this.fecha = fecha;
        this.leido = leido;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Usuario getsenderid() {
        return senderid;
    }

    public void setsenderid(Usuario senderid) {
        this.senderid = senderid;
    }

    public Usuario getreceiverid() {
        return receiverid;
    }

    public void setreceiverid(Usuario receiverid) {
        this.receiverid = receiverid;
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

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
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
                '}';
    }
}
