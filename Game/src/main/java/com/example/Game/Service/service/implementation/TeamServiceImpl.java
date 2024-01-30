package com.example.Game.Service.service.implementation;


import com.example.Game.Dto.Team.CreateTeamDto;
import com.example.Game.Dto.Team.LoginTeamDto;
import com.example.Game.Dto.Team.RestrictedTeamDto;
import com.example.Game.Dto.Team.TeamDto;
import com.example.Game.Model.Team;
import com.example.Game.Model.User;
import com.example.Game.Repo.TeamRepo;
import com.example.Game.Repo.UserTeamRepo;
import com.example.Game.Service.service.TeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service("teamService")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TeamServiceImpl implements TeamService {

    @Autowired
    private final TeamRepo teamRepo;
    @Autowired
    private final UserTeamRepo userTeamRepo;
    @Override
    public ResponseEntity<RestrictedTeamDto> saveTeam(CreateTeamDto Team) {
        if (teamRepo.existsByName(Team.getName()) == true ){
            return new ResponseEntity<RestrictedTeamDto>(HttpStatus.CONFLICT);
        }
        Team teamRequest = mapCreateTeamDTOToTeam(Team);
        teamRequest.setDate_crea(LocalDate.now());
        System.out.println(teamRequest.getName());
        if (teamRepo.save(teamRequest) != null){
            RestrictedTeamDto restrictedTeamDto = mapTeamToRestctedTeamDto(teamRequest);
            return new ResponseEntity<RestrictedTeamDto>(restrictedTeamDto,HttpStatus.CREATED);
        }
        return new ResponseEntity<RestrictedTeamDto>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepo.save(team);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepo.deleteById(id);
    }

    @Override
    public Team findByIdAndPassword(Long id, String password) {
        return teamRepo.findTeamByIdAndPwd(id,password);
    }

    @Override
    public Team findByNameAndPassword(String name, String password) {
        return teamRepo.findTeamByNameAndPwd(name,password);
    }

    @Override
    public TeamDto findByName(String name) {
        TeamDto teamDto = mapTeamToTeamDTO(teamRepo.findTeamByName(name));
        return teamDto;
    }

    @Override
    public boolean checkIfIdexists(Long id) {
        if(teamRepo.findTeamById(id) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfNameExist(String name) {
        return teamRepo.existsByName(name);
    }

    @Override
    public Team findTeamById(Long id) {
        return teamRepo.findTeamById(id);
    }

    @Override
    public Long findIdByName(String name) {

        return teamRepo.findIdByName(name);
    }
    @Override
    public Set<User> findUserByTeam(Long id) {
        Set<User> userReturnDto = userTeamRepo.findByTeam_id(id);
        return userReturnDto;
    }

    private TeamDto mapTeamToTeamDTO(Team team){
        ModelMapper mapper = new ModelMapper();
        TeamDto TeamDTO = mapper.map(team,TeamDto.class);
        return TeamDTO;
    }

    private Team mapTeamDTOToTeam(TeamDto teamDTO){
        ModelMapper mapper = new ModelMapper();
        Team team = new Team(0L,teamDTO.getName(), teamDTO.getNbr_user(), teamDTO.getDate_crea(),null,teamDTO.getUserTeam(),null,null);
        return team;
    }
    private Team mapRestrictedTeamDtoToTeam(RestrictedTeamDto restrictedTeamDto){
        ModelMapper mapper = new ModelMapper();
        Team team = new Team(0L,restrictedTeamDto.getName(), 0, null,null,null,null,null);
        return team;
    }

    private RestrictedTeamDto mapTeamToRestctedTeamDto(Team team){
        ModelMapper mapper = new ModelMapper();
        RestrictedTeamDto restrictedTeamDto = mapper.map(team,RestrictedTeamDto.class);
        return restrictedTeamDto;
    }
    private LoginTeamDto mapTeamToLoginTeamDto(Team team){
        ModelMapper mapper = new ModelMapper();
        LoginTeamDto loginTeamDto = mapper.map(team,LoginTeamDto.class);
        return loginTeamDto;
    }

    private Team mapLoginTeamDtoToTeam(LoginTeamDto loginTeamDto){
        ModelMapper mapper = new ModelMapper();
        Team team = new Team(0L, loginTeamDto.getName(),0, null, loginTeamDto.getPwd(),null,null,null);
        return team;
    }
    private CreateTeamDto mapTeamToCreateTeamDTO(Team team){
        ModelMapper mapper = new ModelMapper();
        CreateTeamDto TeamDTO = mapper.map(team,CreateTeamDto.class);
        return TeamDTO;
    }

    private Team mapCreateTeamDTOToTeam(CreateTeamDto teamDTO){
        ModelMapper mapper = new ModelMapper();
        Team team = new Team(0L,teamDTO.getName(), 0, LocalDate.now(),teamDTO.getPwd(),null,null,null);
        return team;
    }
}
