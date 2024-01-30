package com.example.Game.Repo;

import com.example.Game.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepo extends JpaRepository<Score,Long> {

    public Score findByScore_id(Long id);
    public List<Score> findAllByTeam_id(Long id);
    public List<Score> findAllByScoreMancheID(Long id);
}
