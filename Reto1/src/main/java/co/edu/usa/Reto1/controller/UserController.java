/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.Reto1.controller;

import co.edu.usa.Reto1.model.User;
import co.edu.usa.Reto1.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Indica que UserController va ser un servicio
 * @author migue angel carreño
 */
@RestController
/**
 * Endpoint /api/user
 */
@RequestMapping("/api/user")
/**
 * Permite realizar cualqueir tipo de peticion sin restriccion
 */
@CrossOrigin("*")
/**
 * clase UserController
 */
public class UserController {
    /**
     * @Autowired instancia la clase UserService
     */
     @Autowired
    private UserService userService;
     /**
      * Metodo que permite mostrar todos los usuarios
      * @return retorna todos los usuarios
      */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
     * Metodo post para agregar un usuario
     * @param user datos del uusuario 
     * @return retorna el usuario reguistrado
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    /**
     * Metodo para autenticar un usuario
     * @param email que va atraves de la url
     * @param password que va atraves de la url
     * @return el usuario autenticado con el email y password
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    /**
     * Metodo get que permite saber si el email existe
     * @param email que va atraves de la url
     * @return si existe el email con un true o false
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }   
   /**
    * Fin de la clase UserController
    */ 
}
