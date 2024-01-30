package com.example.Game.Dto.Team;

import com.example.Game.Dto.User.UserReturnDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter@Setter
public class RestrictedTeamDto {
    private Long id;
    private String name;
    private int nbr_user;
    private LocalDate date_crea;
    private Set<UserReturnDto> users;

    public RestrictedTeamDto(Long id, String name, int nbr_user, LocalDate date_crea, Set<UserReturnDto> users) {
        this.id = id;
        this.name = name;
        this.nbr_user = nbr_user;
        this.date_crea = date_crea;

    }

    public RestrictedTeamDto(){}
}
