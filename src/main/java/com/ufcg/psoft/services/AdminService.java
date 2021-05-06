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
public class AdminService {

    @Autowired
    private EmAprovacaoRepository emAprovacaoRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserGovRepository userGovRepository;

    public List<UserGovDTO> findAll() {
        return emAprovacaoRepository.findAll();
    }

    public UserGov changeToUserGov(String cpf) throws Exception {

        User user = userService.findByCPF(cpf);
        UserGovDTO userGovDTO = emAprovacaoRepository.findById(user.getId()).get();

        if(user == null || userGovDTO == null) {
            throw new Exception("Usuário não encontrado!");
        }

        UserGov userGov1 = new UserGov(user);
        userGov1.setCargo(userGovDTO.getCargo());
        userGov1.setLocalTrabalho(userGovDTO.getLocalTrabalho());

        userService.deleteUser(user);
        return userGovRepository.save(userGov1);
    }
}
