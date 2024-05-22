package apirestdelicias.controller;



import apirestdelicias.model.*;
import apirestdelicias.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@EnableAutoConfiguration
public class Controller {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    IntercambioRepository intercambioRepository;
    @Autowired
    MensajeRepository mensajeRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    // Welcome de nuestra api
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String get() {
        String cadena = "<h1 style='text-align: center; background-color: #0000c0; color: #C0C0FF;'>Welcome to Delicias De La Tierra Api with SpringBoot - Alicia Ruiz</h1>";
        cadena +="<table border='1' style='width: 40%;margin: 0 auto; background-color: #C0C0FF; color:#0000c0;'>";
        cadena +="<tr style='background-color: #0000c0; color: #C0C0FF;'><th>Method</th><th>Url</th><th>Description</th></tr>";
        cadena +="<tr><td>get </td><td>/usuarios</td><td>Lista de usuarios</td></tr>";
        cadena +="<tr><td>get </td><td>/usuario/{id}</td><td>Usuario</td></tr>";
        cadena +="<tr><td>post </td><td>/usuario</td><td>Inserta usuario</td></tr>";
        cadena +="<tr><td>get </td><td>/usuario/{id}/productos</td><td>Lista de productos asociados a un usuario</td></tr>";
        cadena +="<tr><td>get </td><td>/categorias</td><td>Lista de categorias</td></tr>";
        cadena +="<tr><td>get </td><td>/categoria/{id}</td><td>Categoria</td></tr>";
        cadena +="<tr><td>post </td><td>/categoria</td><td>Inserta categoria</td></tr>";
        cadena +="<tr><td>delete </td><td>/categoria/{id}</td><td>Borra categoria</td></tr>";
        cadena +="<tr><td>get </td><td>/intercambios</td><td>Lista de intercambios</td></tr>";
        cadena +="<tr><td>get </td><td>/intercambio/{id}</td><td>Intercambio</td></tr>";
        cadena +="<tr><td>post </td><td>/intercambio</td><td>Inserta intercambio</td></tr>";
        cadena +="<tr><td>delete </td><td>/intercambio/{id}</td><td>Borra intercambio</td></tr>";
        cadena +="<tr><td>get </td><td>/mensajes</td><td>Lista de mensajes</td></tr>";
        cadena +="<tr><td>get </td><td>/mensaje/{id}</td><td>Mensaje</td></tr>";
        cadena +="<tr><td>post </td><td>/mensaje</td><td>Inserta mensaje</td></tr>";
        cadena +="<tr><td>delete </td><td>/mensaje/{id}</td><td>Borra mensaje</td></tr>";
        cadena +="<tr><td>get </td><td>/productos</td><td>Lista de productos</td></tr>";
        cadena +="<tr><td>get </td><td>/producto/{id}</td><td>Producto</td></tr>";
        cadena +="<tr><td>post </td><td>/producto</td><td>Inserta producto</td></tr>";
        cadena +="<tr><td>delete </td><td>/producto/{id}</td><td>Borra producto</td></tr>";
        cadena +="</table>";
        return cadena;

    }

    // Get lista con todos los usuarios
    @RequestMapping(value = "usuarios", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsuarios() {
        try {
            Iterable<Usuario> usuarios = usuarioRepository.findAll();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Get un usuario indicando el id en la url
    @RequestMapping(value = "usuario/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsuario(@PathVariable(value = "id") int id) {
        try {
            Usuario usuarioResponse = usuarioRepository.findById(id).orElse(null);
            return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Insert un usuario
    @RequestMapping(value = "usuario", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioResponse = usuarioRepository.save(usuario);
            return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "categorias", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getCategorias() {
        try {
            Iterable<Categoria> categorias = categoriaRepository.findAll();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "categoria", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertarCategoria(@RequestBody Categoria categoria) {
        try {
            Categoria categoriaResponse = categoriaRepository.save(categoria);
            return new ResponseEntity<>(categoriaResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "intercambios", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getIntercambios() {
        try {
            Iterable<Intercambio> intercambios = intercambioRepository.findAll();
            return new ResponseEntity<>(intercambios, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "intercambio", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertarIntercambio(@RequestBody Intercambio intercambio) {
        try {
            Intercambio intercambioResponse = intercambioRepository.save(intercambio);
            return new ResponseEntity<>(intercambioResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "mensajes", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getMensajes() {
        try {
            Iterable<Mensaje> mensajes = mensajeRepository.findAll();
            return new ResponseEntity<>(mensajes, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "mensaje", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertarMensaje(@RequestBody Mensaje mensaje) {
        try {
            Mensaje mensajeResponse = mensajeRepository.save(mensaje);
            return new ResponseEntity<>(mensajeResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "productos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getProductos() {
        try {
            Iterable<Producto> productos = productoRepository.findAll();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "producto", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertarProducto(@RequestBody Producto producto) {
        try {
            System.out.println("Recibido producto: " + producto.getNombre());
            System.out.println("Longitud de imagen: " + (producto.getImagen() != null ? producto.getImagen().length : "null"));
            Producto productoResponse = productoRepository.save(producto);
            return new ResponseEntity<>(productoResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error al guardar producto: " + e);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }


    // Login un usuario
    @RequestMapping(value = "login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        try {
            Usuario usuarioResponse = usuarioRepository.findByEmailAndPassword(email, password);
            if (usuarioResponse != null) {
                return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioResponse = usuarioRepository.save(usuario);
            return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "usuario/{id}/productos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getProductosPorUsuario(@PathVariable(value = "id") int id) {
        try {
            // Primero, verifica si el usuario existe
            Usuario usuario = usuarioRepository.findById(id).orElse(null);
            if (usuario != null) {
                // Si el usuario existe, busca los productos asociados a ese usuario
                List<Producto> productos = productoRepository.findByUsuario(usuario);
                return new ResponseEntity<>(productos, HttpStatus.OK);
            } else {
                // Si el usuario no existe, devuelve un error 404
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            // Si ocurre algún error, devuelve un error 400
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
