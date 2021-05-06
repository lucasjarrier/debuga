package com.ufcg.psoft.repositories;

import com.ufcg.psoft.DTO.UserGovDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmAprovacaoRepository extends JpaRepository<UserGovDTO, Long> {
}
