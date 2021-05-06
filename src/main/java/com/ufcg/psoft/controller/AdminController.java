package com.ufcg.psoft.controller;

import com.ufcg.psoft.DTO.UserGovDTO;
import com.ufcg.psoft.models.UserGov;
import com.ufcg.psoft.models.Vacina;
import com.ufcg.psoft.services.AdminService;
import com.ufcg.psoft.services.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private VacinaService vacinaService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Vacina> cadastrar(@RequestBody Vacina vacina){
        return new ResponseEntity<Vacina>(vacinaService.save(vacina), HttpStatus.ACCEPTED);
    }


    @GetMapping("/listarEmAprovacao")
    public ResponseEntity<List<UserGovDTO>> listar(){
        List<UserGovDTO> userEmAprovacao = adminService.findAll();
        return ResponseEntity.ok(userEmAprovacao);
    }

    @PostMapping
    public ResponseEntity<UserGov> changeToUserGov(@RequestParam String cpf) {
        try {
            return ResponseEntity.ok(adminService.changeToUserGov(cpf));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
