package apirestdelicias.repositories;


import apirestdelicias.model.Producto;
import apirestdelicias.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByEmail(String email);

    Usuario findByEmailAndPassword(String email, String password);


}

