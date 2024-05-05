package apirestdelicias.repositories;


import apirestdelicias.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
