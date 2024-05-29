package apirestdelicias.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Base64;


@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @Column(name = "idcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcategoria;

    @Column(name = "nombre")
    private String nombre;



    @Column(name = "imagen", nullable = true)
    private byte[] imagen;


    public Categoria() {
    }

    public Categoria(Integer idcategoria, String nombre, byte[] imagen) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.imagen= imagen;
    }


    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Categoria{" +
                "idcategoria=" + idcategoria +
                ", nombre='" + nombre + '\'' +
                ", imagen=" + (imagen != null ? "size=" + imagen.length : "null") +
                '}';
    }
}
