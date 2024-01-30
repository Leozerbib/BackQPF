package com.example.Game.Service.service.implementation;


import com.example.Game.Model.Partie;
import com.example.Game.Model.PartieTeam;
import com.example.Game.Model.Team;
import com.example.Game.Repo.PartieTeamRepo;
import com.example.Game.Service.service.PartieTeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("partieTeamService")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PartieTeamServiceImpl implements PartieTeamService {

    @Autowired
    private final PartieTeamRepo partieTeamRepo;
    @Override
    public PartieTeam savePartieTeam(PartieTeam partieTeam) {
        return null;
    }

    @Override
    public PartieTeam updatePArtiTeam(PartieTeam partieTeam) {
        return null;
    }

    @Override
    public void deltePArtieTeam(PartieTeam partieTeam) {

    }

    @Override
    public Set<Team> findTeamByPArtieID(Long id) {
        return null;
    }

    @Override
    public Set<Partie> findPartieByTeamID(Long id) {
        return null;
    }

    @Override
    public boolean checkIfExist(Long id) {
        return false;
    }

    @Override
    public PartieTeam checkIfExistDouble(Long id, Long idx) {
        return null;
    }
}
