package com.ufcg.psoft.repositories;

import com.ufcg.psoft.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
}
