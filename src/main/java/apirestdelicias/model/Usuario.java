package apirestdelicias.model;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idusuario;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "apellidos")
    private String apellidos;

    @Column(name= "email")
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name= "poblacion")
    private String poblacion;

    @Column(name= "provincia")
    private String provincia;


    public Usuario() {
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


     @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
