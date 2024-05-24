package apirestdelicias.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @Column(name = "idproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false)
    private Categoria categoria;


    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;

    public Producto() {
    }

    public Producto(Integer idproducto, String nombre, String descripcion, String fecha, String estado, Categoria categoria, byte[] imagen, Integer idusuario) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.categoria = categoria;
        this.imagen = imagen;
        this.idusuario = idusuario;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getImagenBase64() {
        return Base64.getEncoder().encodeToString(this.imagen);
    }
    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "idproducto=" + idproducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado='" + estado + '\'' +
                ", categoria=" + categoria +
                ", imagen=" + (imagen != null ? "size=" + imagen.length : "null") +
                ", idusuario='" + idusuario + '\'' +
                '}';
    }
}
