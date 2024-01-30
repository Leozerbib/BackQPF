package com.example.Game.Service.service;



import com.example.Game.Model.Partie;
import com.example.Game.Model.PartieTeam;
import com.example.Game.Model.Team;

import java.util.Set;

public interface PartieTeamService {
    public PartieTeam savePartieTeam(PartieTeam partieTeam);
    public PartieTeam updatePArtiTeam(PartieTeam partieTeam);
    public void deltePArtieTeam(PartieTeam partieTeam);
    public Set<Team> findTeamByPArtieID(Long id);
    public Set<Partie> findPartieByTeamID(Long id);
    public boolean checkIfExist(Long id);

    public PartieTeam checkIfExistDouble(Long id, Long idx);
}
