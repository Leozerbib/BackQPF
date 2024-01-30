package com.example.Game.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manche")
@Getter
@Setter
public class manche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manche_id")
    private Long id;

    @Column(name = "manche")
    private int manche;

    @Column(name = "date_manche")
    private LocalDate date_manche;

    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn(name = "partie_id",nullable = false)
    private Partie partie;

    @OneToMany(mappedBy = "ScoreMancheID")
    private Set<Score> scores;


}
