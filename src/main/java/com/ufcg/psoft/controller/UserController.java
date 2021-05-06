package com.ufcg.psoft.controller;

import com.ufcg.psoft.models.User;
import com.ufcg.psoft.services.UserService;
import com.ufcg.psoft.util.Estagio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //OK
    @ApiOperation(value = "Salvar Usuário")
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        try {
            User savedUser = userService.save((user));
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //OK
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        try {
            List<User> users = userService.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //OK
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(value="id") Long id, @RequestBody User user) {
        try {
            User userUpdate = userService.update(id, user);
            return ResponseEntity.ok(userUpdate);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<User> findUser(@PathVariable(value = "cpf") String cpf) {
       return ResponseEntity.ok(userService.findByCPF(cpf));
    }

    //OK
    @PostMapping("/vacinar/{cpf}")
    public ResponseEntity<User> realizarVacinacao(@PathVariable(value = "cpf") String cpf) {
        try{
            User userVacinado = userService.realizarVacinacao(cpf);
            return ResponseEntity.ok(userVacinado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //OK
    @GetMapping("/estadoPaciente/{cpf}")
    public ResponseEntity<Estagio> consultarEstado(@PathVariable(value = "cpf") String cpf) {
        try {
            return new ResponseEntity(userService.consultarEstado(cpf),HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}