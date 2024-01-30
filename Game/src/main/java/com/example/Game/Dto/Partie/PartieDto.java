package com.example.Game.Dto.Partie;

import com.example.Game.stateGame.stateGame;
import com.example.Game.Model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartieDto {
    private Long id;
    private LocalDate endDate;
    private LocalDate startDate;
    private int nbr_manche;
    private stateGame state;
    private Set<Team> teams;
}
