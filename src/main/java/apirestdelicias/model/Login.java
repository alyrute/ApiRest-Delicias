package apirestdelicias.model;

public class Login {
    private String email;
    private String password;

    // Constructor por defecto
    public Login() {
    }

    // Constructor con parámetros
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y setters
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
}
