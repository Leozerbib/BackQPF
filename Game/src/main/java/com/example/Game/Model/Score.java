package com.example.Game.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long score_id;

    @ManyToOne
    @JoinColumn(name = "score_manche_id")
    private manche ScoreMancheID;

    @Column(name = "date_manche")
    private LocalDate date_manche;

    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team_id;



}
