package com.example.Game.Repo;


import com.example.Game.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByAge(int age);
    public User findByUsername(String username);
    public User findByNames(String names);
    public User findByEmail(String email);
    public Optional<User> findById(Long id);
    public User findByIdAndPasswords(Long id, String passwords);
    public User findByUsernameOrEmail(String Log, String Logs);

}
