package com.example.Game.Dto.Partie;

import com.example.Game.stateGame.stateGame;

import java.time.LocalDate;

public class PartieInfoDto {
    private Long id;
    private LocalDate endDate;
    private LocalDate startDate;
    private int nbr_manche;
    private stateGame state;
}
