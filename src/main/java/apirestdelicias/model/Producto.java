package apirestdelicias.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @Column(name= "idproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "descripcion")
    private String descripcion;

    @Column(name= "fecha")
    private Date fecha;

    @Column(name= "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private Categoria idcategoria;

    @Column(name= "imagen")
    private String imagen;

    public Producto() {
    }

    public Producto(Integer idproducto, String nombre, String descripcion, Date fecha, String estado, Categoria idcategoria, String imagen) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.idcategoria = idcategoria;
        this.imagen = imagen;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idproducto=" + idproducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", idcategoria=" + idcategoria +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}