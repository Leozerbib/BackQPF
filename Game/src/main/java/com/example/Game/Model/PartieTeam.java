package com.example.Game.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partie_team")
@Getter@Setter
public class PartieTeam implements Serializable {
    @Id
    private Long id;

    @Column(name = "partie_id")
    private Long id_Partie;

    @Column(name = "team_id")
    private Long id_Team;



}
