package com.ufcg.psoft.repositories;

import com.ufcg.psoft.models.UserGov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserGovRepository extends JpaRepository<UserGov, Long> {
}
