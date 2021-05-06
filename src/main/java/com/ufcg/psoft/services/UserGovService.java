package com.ufcg.psoft.services;

import com.ufcg.psoft.DTO.UserGovDTO;
import com.ufcg.psoft.models.User;
import com.ufcg.psoft.models.UserGov;
import com.ufcg.psoft.repositories.EmAprovacaoRepository;
import com.ufcg.psoft.repositories.UserGovRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGovService {

    @Autowired
    private UserGovRepository userGovRepository;

    @Autowired
    private EmAprovacaoRepository emAprovacaoRepository;

    @Autowired
    private UserService userService;

    public List<UserGov> findAll() {
        return userGovRepository.findAll();
    }

    public void EmAprovacao(UserGovDTO userGovDTO) {

        User user = userService.findByCPF(userGovDTO.getCpf());
        if(user != null) {
            emAprovacaoRepository.save(userGovDTO);
        }
    }

}
