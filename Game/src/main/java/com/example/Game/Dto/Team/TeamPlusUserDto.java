package com.example.Game.Dto.Team;

import com.example.Game.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlusUserDto {
    private String name;
    private int nbr_user;
    private Set<User> users;
}
