package apirestdelicias.repositories;


import apirestdelicias.model.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeRepository extends CrudRepository<Mensaje, Integer> {
}
