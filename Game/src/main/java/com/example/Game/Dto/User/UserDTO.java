package com.example.Game.Dto.User;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
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
