package com.example.Game.Service.service;


import com.example.Game.Dto.Partie.PartieDto;
import com.example.Game.Dto.Partie.PartieTeamDto;
import com.example.Game.Model.Partie;
import org.springframework.http.ResponseEntity;

public interface PartieService {
    public ResponseEntity<Partie> savePartie(Partie partie);
    public PartieDto updatePArtie(Long id);
    public void deletePartie(Long id);
    public PartieTeamDto findById(Long id);

}
