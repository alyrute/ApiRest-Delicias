package apirestdelicias.controller;



import apirestdelicias.model.*;
import apirestdelicias.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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
        cadena += "<table border='1' style='width: 40%;margin: 0 auto; background-color: #C0C0FF; color:#0000c0;'>";
        cadena += "<tr style='background-color: #0000c0; color: #C0C0FF;'><th>Method</th><th>Url</th><th>Description</th></tr>";
        cadena += "<tr><td>GET </td><td>/usuarios</td><td>Lista de usuarios</td></tr>";
        cadena += "<tr><td>GET </td><td>/usuario/{id}</td><td>Usuario</td></tr>";
        cadena += "<tr><td>POST </td><td>/usuario</td><td>Inserta usuario</td></tr>";
        cadena += "<tr><td>GET </td><td>/login</td><td>Login de usuario</td></tr>";
        cadena += "<tr><td>POST </td><td>/register</td><td>Registro de usuario</td></tr>";
        cadena += "<tr><td>GET </td><td>/categorias</td><td>Lista de categorias</td></tr>";
        cadena += "<tr><td>POST </td><td>/categoria</td><td>Inserta categoria</td></tr>";
        cadena += "<tr><td>GET </td><td>/categoria/{idcategoria}/producto</td><td>Lista de productos por categoria</td></tr>";
        cadena += "<tr><td>GET </td><td>/productos</td><td>Lista de productos</td></tr>";
        cadena += "<tr><td>POST </td><td>/producto</td><td>Inserta producto</td></tr>";
        cadena += "<tr><td>GET </td><td>/producto/{idproducto}/usuario</td><td>Usuario de un producto</td></tr>";
        cadena += "<tr><td>GET </td><td>/mensajes/producto/{idproducto}</td><td>Lista de mensajes por producto</td></tr>";
        cadena += "<tr><td>POST </td><td>/mensaje</td><td>Inserta mensaje</td></tr>";
        cadena += "</table>";
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

    @RequestMapping(value = "/categoria/{idcategoria}/producto", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, List<Producto>>> getProductoPorCategoria(@PathVariable Integer idcategoria) {
        List<Producto> productos = productoRepository.findByCategoriaIdcategoria(idcategoria);
        if (!productos.isEmpty()) {
            Map<String, List<Producto>> response = new HashMap<>();
            response.put("producto", productos);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "productos/{idusuario}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, List<Producto>>> getProductosPorUsuario(@PathVariable Integer idusuario) {
        List<Producto> productos= productoRepository.findByUsuario_Idusuario(idusuario);
        if (!productos.isEmpty()) {
            Map<String, List<Producto>> response = new HashMap<>();
            response.put("producto", productos);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "producto", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertarProducto(@RequestBody Producto producto) {
        try {
            Producto productoResponse = productoRepository.save(producto);
            return new ResponseEntity<>(productoResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/producto/{idproducto}/usuario", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Usuario> obtenerUsuarioPorProducto(@PathVariable Integer idproducto) {
        Optional<Producto> optionalProducto = productoRepository.findById(idproducto);
        if (!optionalProducto.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Producto producto = optionalProducto.get();
        Usuario usuario = producto.getUsuario();
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }


    @RequestMapping(value = "mensajes/producto/{idproducto}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Mensaje>> getMensajesByIdProducto(@PathVariable Integer idproducto, @RequestParam Integer senderid, @RequestParam Integer receiverid) {
        try {
            // Recuperar mensajes enviados por el remitente para el producto dado
            List<Mensaje> mensajesEnviados = mensajeRepository.findBySenderidAndIdproducto(senderid, idproducto);

            // Recuperar mensajes recibidos por el receptor para el producto dado
            List<Mensaje> mensajesRecibidos = mensajeRepository.findByReceiveridAndIdproducto(receiverid, idproducto);

            // Combinar ambos conjuntos de mensajes en una lista final
            List<Mensaje> mensajes = new ArrayList<>();
            mensajes.addAll(mensajesEnviados);
            mensajes.addAll(mensajesRecibidos);

            return new ResponseEntity<>(mensajes, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Error al obtener los mensajes relacionados con el producto: " + ex.getMessage());
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

    // Endpoint para eliminar un producto
    @DeleteMapping(value = "producto/{idproducto}")
    public ResponseEntity<?> eliminarProducto(@PathVariable("idproducto") Integer id) {
        try {
            Optional<Producto> productoOptional = productoRepository.findById(id);
            if (!productoOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
