package com.example.Game.Service.service;


import com.example.Game.Dto.Team.CreateTeamDto;
import com.example.Game.Dto.Team.RestrictedTeamDto;
import com.example.Game.Dto.Team.TeamDto;
import com.example.Game.Model.Team;
import com.example.Game.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface TeamService {
    public ResponseEntity<RestrictedTeamDto> saveTeam(CreateTeamDto Team);
    public Team updateTeam(Team team);
    public void deleteTeam(Long id);
    public Team findByIdAndPassword(Long id, String password);
    public Team findByNameAndPassword(String name, String password);
    public TeamDto findByName(String name);
    public boolean checkIfIdexists(Long id);
    public boolean checkIfNameExist(String name);
    public Team findTeamById(Long id);
    public Long findIdByName(String name);
    public Set<User> findUserByTeam(Long id);
}
