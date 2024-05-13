package apirestdelicias.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "intercambio")
public class Intercambio implements Serializable {

    @Id
    @Column(name = "idintercambio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idintercambio;

    @ManyToOne
    @JoinColumn(name = "idusuario1", referencedColumnName = "idusuario")
    private Usuario idusuario1;

    @ManyToOne
    @JoinColumn(name = "idusuario2", referencedColumnName = "idusuario")
    private Usuario idusuario2;

    @ManyToOne
    @JoinColumn(name = "idproducto1", referencedColumnName = "idproducto")
    private Producto idproducto1;

    @ManyToOne
    @JoinColumn(name = "idproducto2", referencedColumnName = "idproducto")
    private Producto idproducto2;

    @Column(name = "estado_intercambio")
    private String estado_intercambio;

    public Intercambio() {
    }

    public Intercambio(Integer idintercambio, Usuario idusuario1, Usuario idusuario2, Producto idproducto1, Producto idproducto2, String estado_intercambio) {
        this.idintercambio = idintercambio;
        this.idusuario1 = idusuario1;
        this.idusuario2 = idusuario2;
        this.idproducto1 = idproducto1;
        this.idproducto2 = idproducto2;
        this.estado_intercambio = estado_intercambio;
    }

    public Integer getIdintercambio() {
        return idintercambio;
    }

    public void setIdintercambio(Integer idintercambio) {
        this.idintercambio = idintercambio;
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

    public Producto getIdproducto1() {
        return idproducto1;
    }

    public void setIdproducto1(Producto idproducto1) {
        this.idproducto1 = idproducto1;
    }

    public Producto getIdproducto2() {
        return idproducto2;
    }

    public void setIdproducto2(Producto idproducto2) {
        this.idproducto2 = idproducto2;
    }

    public String getEstado_intercambio() {
        return estado_intercambio;
    }

    public void setEstado_intercambio(String estado_intercambio) {
        this.estado_intercambio = estado_intercambio;
    }

    @Override
    public String toString() {
        return "Intercambio{" +
                "idintercambio=" + idintercambio +
                ", idusuario1=" + idusuario1 +
                ", idusuario2=" + idusuario2 +
                ", idproducto1=" + idproducto1 +
                ", idproducto2=" + idproducto2 +
                ", estado_intercambio='" + estado_intercambio + '\'' +
                '}';
    }
}