package com.example.Game.Repo;

import com.example.Game.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PartieTeamRepo extends JpaRepository<PartieTeam,Long> {

    @Query(value = "select  p from Partie p join p.teams t where t.id = :teamID",
            nativeQuery = false)
    public Set<Partie> findByTeam_id(Long teamID);

    @Query(value = "select  t from Partie p join p.teams t where p.id = :partieID",
            nativeQuery = false)
    public Set<Team> findByPartie_id(Long partieID);
}
