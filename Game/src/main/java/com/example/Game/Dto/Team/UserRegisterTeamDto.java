package com.example.Game.Dto.Team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterTeamDto {
    private Long idteam;
    private Long Id;
    private String names;
    private String lastname;
    private String username;
    private int age;
    private LocalDate date_crea;
    private LocalDate LastCo;
    private String email;
    private String passwords;
}
