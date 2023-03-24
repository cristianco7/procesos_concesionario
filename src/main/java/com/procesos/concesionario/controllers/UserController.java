package com.procesos.concesionario.controllers;

import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id) {
        Map response = new HashMap<>();
        try {
            response.put("message", "Se encontro el usuario");
            response.put("data", userServiceImpl.getUserById(id));
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {
            response.put("message", "No se encontro el usuario");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.OK);

        }

    }

    @PostMapping(value = "/user")
    public ResponseEntity createUser(@RequestBody User user) {
        Map response = new HashMap<>();
        try {
            response.put("message", "Se guardo el usuario");
            response.put("data", userServiceImpl.createUser(user));
            return new ResponseEntity(response, HttpStatus.CREATED);

        } catch (Exception e) {
            response.put("message", "No se guardo el usuario");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);


        }
    }
    @GetMapping (value="/user/list")
    public ResponseEntity alluser(){
        Map response = new HashMap<>();
        try {
            response.put("message", "Lista de usuarios");
            response.put("data", userServiceImpl.allUsers());
            return new ResponseEntity(response, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            response.put("message", "Lista de usuarios");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);


        }

    }
    @PutMapping (value = "/user/{id}")
    public ResponseEntity updateUser (@PathVariable(name = "id") Long id, User user) {
        Map response = new HashMap();
        try {
            response.put("message", "Actualizar usuarios");
            response.put("data", userServiceImpl.updateUser(id, user));
            return new ResponseEntity(response, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            response.put("message", "Lista de usuarios");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);


        }
    }
}