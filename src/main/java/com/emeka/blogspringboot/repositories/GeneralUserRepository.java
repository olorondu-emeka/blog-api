package com.emeka.blogspringboot.repositories;

import com.emeka.blogspringboot.models.GeneralUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneralUserRepository extends JpaRepository<GeneralUser, Integer> {
    Optional<GeneralUser> findByEmail(String email);
}
