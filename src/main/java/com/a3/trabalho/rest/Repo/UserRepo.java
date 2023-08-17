package com.a3.trabalho.rest.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.a3.trabalho.rest.Modelos.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}
