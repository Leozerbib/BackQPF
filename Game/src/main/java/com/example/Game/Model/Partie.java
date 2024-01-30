package com.example.Game.Model;

import com.example.Game.stateGame.stateGame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partie")
public class Partie {
    @Id
    @GeneratedValue(generator = "sequence-generator4")
    @GenericGenerator(
            name = "sequence-generator4",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "Partie_sequence2"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "partie_id")
    private Long id;

    @Column(name = "enddate",nullable = false)
    private LocalDate endDate;

    @Column(name = "date_crea",nullable = false)
    private LocalDate startDate;

    @Column(name = "nbr_manche",nullable = false)
    private int nbr_manche;

    @Column(name = "state",nullable = false)
    private stateGame state;

    @ManyToMany
    @JoinTable(name = "partie_team",
            joinColumns = @JoinColumn(name = "partie_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> teams;

    @OneToMany(mappedBy = "partie")
    private Set<manche> manches;
}
