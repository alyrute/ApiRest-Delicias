package apirestdelicias.repositories;


import apirestdelicias.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
