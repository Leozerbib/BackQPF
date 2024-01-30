package com.example.Game.Controler;


import com.example.Game.Dto.Team.TeamDto;
import com.example.Game.Dto.User.UserTeamDTO;
import com.example.Game.Model.User;
import com.example.Game.Service.service.implementation.TeamServiceImpl;
import com.example.Game.Service.service.implementation.UserteamServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RequestMapping("/Bibze/UserTeam")
@RequiredArgsConstructor
@RestController
public class UserTeam_controler {

    @Autowired
    private UserteamServiceImpl userteamService;

    @Autowired
    private TeamServiceImpl teamService;

    @PostMapping(path = "/create_UserTeam")
    public Long create(UserTeamDTO userTeam){
        System.out.println(userTeam);
        userteamService.saveUserTeam(userTeam);
        return userTeam.getTeam_id();
    }

    @PutMapping(path = "/update_UserTeam")
    public ResponseEntity<UserTeamDTO> UpdateUserTeam(UserTeamDTO userTeamDTO){

        return new ResponseEntity<UserTeamDTO>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(path = "/delete_UserTeam/{userteam_id}")
    public ResponseEntity<UserTeamDTO> Delete(Long id){
        userteamService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @GetMapping(path = "/get/findUserbyTeam")
    public ResponseEntity<Set<User>> findUserByTeam(TeamDto teamDto){
        Set<User> userDTOList = userteamService.findUserByTeam(teamDto.getId());
        return new ResponseEntity<Set<User>>(userDTOList,HttpStatus.FOUND);
    }

}
