package com.unicuritiba.boleto.domain.repositories;

import com.unicuritiba.boleto.domain.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, String> {

    UserDetails findByLogin(String login);
}
