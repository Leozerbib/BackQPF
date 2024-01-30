package com.example.Game.Service.service.implementation;


import com.example.Game.Dto.User.UserReturnDto;
import com.example.Game.Dto.User.UserTeamDTO;
import com.example.Game.Model.Team;
import com.example.Game.Model.User;
import com.example.Game.Model.UserTeam;
import com.example.Game.Repo.TeamRepo;
import com.example.Game.Repo.UserTeamRepo;
import com.example.Game.Service.service.UserTeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service("userTeamService")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserteamServiceImpl implements UserTeamService {
    @Autowired
    private final UserTeamRepo userTeamRepo;
    @Autowired
    private final TeamRepo teamRepo;
    @Override
    public ResponseEntity<UserTeam> saveUserTeam(UserTeamDTO UserTeam) {
        if (userTeamRepo.existsById(UserTeam.getTeam_id())){
            return new ResponseEntity<UserTeam>(HttpStatus.CONFLICT);
        }
        userTeamRepo.save(mapUserTeamDTOToUserTeam(UserTeam));
        return new ResponseEntity<UserTeam>(HttpStatus.CREATED);

    }

    @Override
    public UserTeam updateUserTeam(UserTeam userTeam) {
        return userTeamRepo.save(userTeam);
    }

    @Override
    public void deleteUser(Long id) {
        userTeamRepo.deleteById(id);
    }

    @Override
    public Set<User> findUserByTeam(Long id) {
        Set<User> userofTeam = userTeamRepo.findByTeam_id(id);
        return userofTeam;
    }

    @Override
    public boolean checkIfExist(Long id){
        return userTeamRepo.existsById(id);
    }

    @Override
    public UserTeam checkIfExistDouble(Long id, Long idx) {
        return userTeamRepo.findByTeam_idAndUser_idEqualsAndTeam_idEquals(id, idx);
    }

    @Override
    public Collection<Team> findTeamByUser(Long id) {
        return null;
    }

    private UserTeamDTO mapUserTeamToUserTeamDTO(UserTeam userTeam){
        ModelMapper mapper = new ModelMapper();
        UserTeamDTO userTeamDTO = mapper.map(userTeam,UserTeamDTO.class);
        return userTeamDTO;
    }

    private UserTeam mapUserTeamDTOToUserTeam(UserTeamDTO userTeamDTO){
        ModelMapper mapper = new ModelMapper();
        UserTeam userTeam = new UserTeam(0L,userTeamDTO.getUser_id(),userTeamDTO.getTeam_id(),userTeamDTO.getDateCrea());
        return userTeam;
    }
    private UserReturnDto mapUserToUserReturnDTO(User user){
        ModelMapper mapper = new ModelMapper();
        UserReturnDto userReturnDTO = mapper.map(user,UserReturnDto.class);
        return userReturnDTO;
    }


}
