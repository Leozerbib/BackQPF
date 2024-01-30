package com.example.Game.Model;

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
@Table(name = "users")

public class User {
    @jakarta.persistence.Id
    @GeneratedValue(generator = "sequence-generator1")
    @GenericGenerator(
            name = "sequence-generator1",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence2"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "user_id")
    private Long Id;

    @Column(name = "names",nullable = false)
    private String names;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "date_crea")
    private LocalDate date_crea;

    @Column(name = "last_co")
    private LocalDate last_co;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "passwords",nullable = false)
    private String passwords;

    @Column(name = "icon" )
    private String icon;

    @ManyToMany(mappedBy = "users")
    private Set<Team> teams;
}
