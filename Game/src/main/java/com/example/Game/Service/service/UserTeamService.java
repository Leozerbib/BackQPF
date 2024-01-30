package com.example.Game.Service.service;


import com.example.Game.Dto.User.UserTeamDTO;
import com.example.Game.Model.Team;
import com.example.Game.Model.User;
import com.example.Game.Model.UserTeam;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Set;

public interface UserTeamService {
    public ResponseEntity<UserTeam> saveUserTeam(UserTeamDTO UserTeam);
    public UserTeam updateUserTeam(UserTeam userTeam);
    public void deleteUser(Long id);
    public Set<User> findUserByTeam(Long id);
    public Collection<Team> findTeamByUser(Long id);
    public boolean checkIfExist(Long id);

    public UserTeam checkIfExistDouble(Long id,Long idx);
}
