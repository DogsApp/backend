package com.doggo.userservice.repository;

import java.util.Optional;

import com.doggo.userservice.entity.ERole;
import com.doggo.userservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
