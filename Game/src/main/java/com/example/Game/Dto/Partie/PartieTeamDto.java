package com.example.Game.Dto.Partie;

import com.example.Game.stateGame.stateGame;
import com.example.Game.Model.Team;

import java.util.Set;

public class PartieTeamDto {
    private Long id;
    private int nbr_manche;
    private stateGame state;
    private Set<Team> teams;
}
