package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Login;

import org.example.dto.Register;
import org.example.entity.RegisterEntity;
import org.example.service.LoginService;
import org.example.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
@CrossOrigin
@Slf4j
public class RegisterController {
    private final RegisterService registerService;
    private final LoginService loginService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody Register register) {
        if (registerService.isExists(register.getEmail())){
            return ResponseEntity.badRequest().body("Can't register user already exists");
        }else {
            loginService.addUser(new Login(register.getId(), register.getEmail(), register.getPassword()));
            registerService.addUser(register);
            return ResponseEntity.ok("User Registered");
        }
    }


    @GetMapping("/get")
    public List<RegisterEntity> getAll(){
       return registerService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
      registerService.deleteById(id);
      return ResponseEntity.ok("Deleted");
    }

    @PostMapping("/isExists")
    public ResponseEntity<?> isExists(@RequestBody String email,String password ){
        registerService.isExists(email);
        return ResponseEntity.ok("Can't register user already registered");
    }

    @GetMapping("/exists-user/{userName}")
    public ResponseEntity<?> existsByUserName(@PathVariable String userName) {
        if (registerService.existsByUserName(userName)) {
            return ResponseEntity.ok("User Exists");
        } else {
            return ResponseEntity.ok("User not registerd");
        }

    }

}
