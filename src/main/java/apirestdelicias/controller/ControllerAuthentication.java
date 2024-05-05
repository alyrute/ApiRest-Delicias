package apirestdelicias.controller;

import apirestdelicias.model.Login;
import apirestdelicias.model.Usuario;
import apirestdelicias.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class ControllerAuthentication {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        Usuario usuario = usuarioRepository.findByEmail(login.getUsuario());
        if (usuario != null && usuario.getPassword().equals(login.getPassword())) {
            return ResponseEntity.ok("¡Inicio de sesión exitoso!");
        } else {
            return ResponseEntity.badRequest().body("Credenciales inválidas. Inténtalo de nuevo.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        Usuario existingUser = usuarioRepository.findByEmail(usuario.getEmail());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("Ya existe un usuario con ese correo electrónico.");
        }

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Registro exitoso!");
    }
}