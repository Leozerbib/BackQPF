package com.example.Game.Dto.Team;

import com.example.Game.Model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter@Setter
public class TeamWithUserDto {
    private int team_id;
    private Set<User> userTeam;
    private String name;
    private LocalDate Date_crea;
    public TeamWithUserDto(int team_id, Set<User> userTeam, String name, LocalDate date_crea) {
        this.team_id = team_id;
        this.userTeam = userTeam;
        this.name = name;
        Date_crea = date_crea;
    }

    public TeamWithUserDto(){

    }

}
