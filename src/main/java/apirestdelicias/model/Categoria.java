package apirestdelicias.model;





import javax.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @Column(name = "idcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcategoria;

    @Column(name = "nombre")
    private String nombre;

    public Categoria() {
    }

    public Categoria(Integer idcategoria, String nombre) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Categoria{" +
                "idcategoria=" + idcategoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
