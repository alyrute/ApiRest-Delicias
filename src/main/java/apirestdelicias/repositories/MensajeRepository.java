package apirestdelicias.repositories;


import apirestdelicias.model.Mensaje;
import apirestdelicias.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensajeRepository extends CrudRepository<Mensaje, Integer> {
    List<Mensaje> findBySenderid(Integer senderid);
    List<Mensaje> findByReceiverid(Integer receiverid);

    // Corrige los nombres de los parámetros aquí.
    List<Mensaje> findByReceiveridAndIdproducto(Integer receiverid, Integer idproducto);
    List<Mensaje> findBySenderidAndIdproducto(Integer senderid, Integer idproducto);

}