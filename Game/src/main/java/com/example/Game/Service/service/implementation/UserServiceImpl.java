package com.example.Game.Service.service.implementation;


import com.example.Game.Model.User;
import com.example.Game.Dto.User.CreateUserDto;
import com.example.Game.Dto.User.RestrictedUserDro;
import com.example.Game.Dto.User.UserDTO;
import com.example.Game.Repo.UserRepo;
import com.example.Game.Service.service.iuserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service("userService")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements iuserService {

    @Autowired
    private final UserRepo userRepo;
    @Override
    public ResponseEntity<User> saveUser(CreateUserDto User) {
        if (findUserByUsername(User.getUsername()) != null) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        User customerRequest = new User(null, User.getNames(), User.getLastname(), User.getUsername(), User.getAge(), LocalDate.now(),LocalDate.now(), User.getEmail(), User.getPasswords(),"https://yoolk.ninja/wp-content/uploads/2022/04/OnePiece-Monkey-D-Luffy.png",null);
        System.out.println(customerRequest.getUsername());
        User customerResponse = userRepo.save(customerRequest);
        if (customerResponse != null) {
            return new ResponseEntity<User>(customerResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public User updateUser(User User) {
        log.info("User udpate : {}",User.getId());
        return userRepo.save(User);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("User delete : {}",id  );
        userRepo.deleteById(id);
    }

    @Override
    public RestrictedUserDro findByIdAndPassword(Long id, String passwords) {
        return mapUserToresUserDTO(userRepo.findByIdAndPasswords(id, passwords));
    }

    @Override
    public User findByUsernameOrEmail(String log, String logs) {
        return userRepo.findByUsernameOrEmail(log,logs);
    }

    @Override
    public User findUserByUsername(String username) {
        log.info("username : {}",username );
        return userRepo.findByUsername(username);
    }
    @Override
    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }

    @Override
    public User findUserByNames(String names) {

        return userRepo.findByNames(names);
    }

    @Override
    public boolean checkIfIdexists(Long id) {

        return false;
    }

    @Override
    public List<User> getUserByAge(int age) {

        return (List<User>) userRepo.findByAge(age);
    }

    @Override
    public Collection<User> getAllbyAge(int age){
        log.info("User by age : {}",age  );
        return (Collection<User>) userRepo.findByAge(age);
    }
    /**
     * Transforme une entity Customer en un POJO CustomerDTO
     *
     * @param User
     * @return
     */
    private UserDTO mapUserToUserDTO(User User) {
        ModelMapper mapper = new ModelMapper();
        UserDTO UserDTO = mapper.map(User, UserDTO.class);
        return UserDTO;
    }
    /**
     * Transforme un POJO CustomerDTO en une entity Customer
     *
     * @param UserDTO
     * @return
     */
    private User mapUserDTOToUser(UserDTO UserDTO) {
        ModelMapper mapper = new ModelMapper();
        User User = new User(1L, UserDTO.getNames(), UserDTO.getLastname(), UserDTO.getUsername(), UserDTO.getAge(), LocalDate.now(),LocalDate.now(), UserDTO.getEmail(), UserDTO.getPasswords(),null,null);
        return User;
    }
    private RestrictedUserDro mapUserToresUserDTO(User User) {
        ModelMapper mapper = new ModelMapper();
        RestrictedUserDro UserDTO = mapper.map(User, RestrictedUserDro.class);
        return UserDTO;
    }
    /**
     * Transforme un POJO CustomerDTO en une entity Customer
     *
     * @param UserDTO
     * @return
     */
    private User mapresUserDTOToUser(RestrictedUserDro UserDTO) {
        ModelMapper mapper = new ModelMapper();
        User User = new User(1L, null, null, UserDTO.getUsername(), 0, LocalDate.now(),LocalDate.now(), null, null,null,null);
        return User;
    }
}
