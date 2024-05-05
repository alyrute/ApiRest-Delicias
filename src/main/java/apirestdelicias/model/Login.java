package apirestdelicias.model;

public class Login {
    private String usuario;
    private String password;

    // Constructor por defecto
    public Login() {
    }

    // Constructor con parámetros
    public Login(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    // Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
