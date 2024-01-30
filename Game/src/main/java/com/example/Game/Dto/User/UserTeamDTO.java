package com.example.Game.Dto.User;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
public class UserTeamDTO {
    private Long user_id;
    private Long team_id;
    private LocalDate dateCrea;

    public UserTeamDTO( Long user_id, Long team_id, LocalDate dateCrea) {
        this.user_id = user_id;
        this.team_id = team_id;
        this.dateCrea = dateCrea;
    }

    public UserTeamDTO(){}
}
