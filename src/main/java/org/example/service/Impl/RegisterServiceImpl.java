package org.example.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Register;
import org.example.entity.RegisterEntity;
import org.example.repository.RegisterRepository;
import org.example.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final ModelMapper modelMapper;
    private final RegisterRepository registerRepository;
    @Override
    public void addUser(Register register) {
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        String encrptPassword = passwordEncoder.encode(register.getPassword());
        register.setPassword(encrptPassword);
        registerRepository.save(modelMapper.map(register, RegisterEntity.class));
    }

    @Override
    public List<RegisterEntity> getAll() {
        return registerRepository.findAll();
    }

    @Override
    public Boolean deleteById(Long id) {
      registerRepository.deleteById(id);
     return true;
    }

    @Override
    public Boolean isExists(String email, String password) {
       return registerRepository.existsByEmailAndPassword(email,password);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return registerRepository.existsByUserName(userName);
    }


}
