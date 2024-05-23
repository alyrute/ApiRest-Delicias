package apirestdelicias.repositories;


import apirestdelicias.model.Producto;
import apirestdelicias.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByUsuario(Usuario usuario);

}

