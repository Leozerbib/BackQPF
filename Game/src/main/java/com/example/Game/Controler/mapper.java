package com.example.Game.Controler;


import com.example.Game.Dto.User.UserDTO;
import com.example.Game.Dto.User.UserReturnDto;
import com.example.Game.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class mapper {
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
        User User = mapper.map(UserDTO, User.class);
        return User;
    }
    public Optional<UserReturnDto> mapUserToUserDTORetur(Optional<User> User) {
        ModelMapper mapper = new ModelMapper();
        Optional<UserReturnDto> UserDTO = Optional.ofNullable(mapper.map(User, UserReturnDto.class));
        return UserDTO;
    }
    public UserReturnDto mapUserToUserDTOReturn(User User) {
        ModelMapper mapper = new ModelMapper();
        UserReturnDto UserDTO = mapper.map(User, UserReturnDto.class);
        return UserDTO;
    }
}
