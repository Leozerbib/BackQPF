package com.example.Game.Service.service;

import com.example.Game.Dto.User.CreateUserDto;
import com.example.Game.Dto.User.RestrictedUserDro;
import com.example.Game.Model.User;

import com.example.Game.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface iuserService {
    public ResponseEntity<User> saveUser(CreateUserDto User);
    public User updateUser(User User);

    public void deleteUser(Long id);
    public RestrictedUserDro findByIdAndPassword(Long id, String passwords);
    public User findByUsernameOrEmail(String log, String logs);

    public User findUserByUsername(String username);
    public User findUserByNames(String names);
    public boolean checkIfIdexists(Long id);
    public List<User> getUserByAge(int age);
    public Collection<User> getAllbyAge(int age);
    public Optional<User> findById(Long id);

}
