package org.example.repository;

import org.example.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterEntity,Long> {
   Boolean existsByEmailAndPassword(String email,String password);
   Boolean existsByUserName(String username);
}
