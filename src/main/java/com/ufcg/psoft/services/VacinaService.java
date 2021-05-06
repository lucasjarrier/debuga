package com.ufcg.psoft.services;

import com.ufcg.psoft.models.User;
import com.ufcg.psoft.models.Vacina;
import com.ufcg.psoft.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    public Vacina save(Vacina vacina) {
        return vacinaRepository.save((vacina));
    }
}
