package com.example.Game.Repo;

import com.example.Game.Model.Partie;
import com.example.Game.Model.manche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MancheRepo extends JpaRepository<manche,Long> {
    public manche findById();
    public List<manche> findAllByPartie(Partie partie);

}
