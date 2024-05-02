package org.example.repository;

import org.example.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterEntity,Long> {
   Boolean existsByEmail(String email);
   Boolean existsByUserName(String username);
}
