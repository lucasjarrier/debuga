package com.ufcg.psoft.controller;

import com.ufcg.psoft.DTO.UserGovDTO;
import com.ufcg.psoft.models.UserGov;
import com.ufcg.psoft.services.UserGovService;
import com.ufcg.psoft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/gov")
public class UserGovController {

    @Autowired
    UserGovService userGovService;

    @GetMapping
    public ResponseEntity<List<UserGov>> findAll() {
        try {
            return ResponseEntity.ok(userGovService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/mudar")
    public ResponseEntity mudar(@RequestBody UserGovDTO userGovDTO) {
        try {
            userGovService.EmAprovacao(userGovDTO);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
