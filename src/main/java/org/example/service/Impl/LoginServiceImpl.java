package org.example.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Login;
import org.example.entity.LoginEntity;
import org.example.repository.LoginRepository;
import org.example.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final ModelMapper modelMapper;


    @Override
    public void addUser(Login login) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encrptPassword = passwordEncoder.encode(login.getPassword());
        login.setPassword(encrptPassword);
        loginRepository.save(modelMapper.map(login, LoginEntity.class));
    }
}
