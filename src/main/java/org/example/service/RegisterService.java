package org.example.service;

import org.example.dto.Register;
import org.example.entity.RegisterEntity;

import java.util.List;

public interface RegisterService {
    void addUser(Register register);

    public List<RegisterEntity> getAll();


    Boolean deleteById(Long id);

    Boolean isExists(String email, String password);

    Boolean existsByUserName(String userName);
}
