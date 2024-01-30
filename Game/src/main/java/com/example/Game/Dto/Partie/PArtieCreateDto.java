package com.example.Game.Dto.Partie;

import com.example.Game.Model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PArtieCreateDto {
    private int nbr_manche;
    private Set<Team> teams;

}
