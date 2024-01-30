package com.example.Game.Controler;


import com.example.Game.Dto.Partie.PArtieCreateDto;
import com.example.Game.Model.Partie;
import com.example.Game.Model.manche;
import com.example.Game.Service.service.implementation.PartieServiceImpl;
import com.example.Game.Service.service.implementation.PartieTeamServiceImpl;
import com.example.Game.stateGame.stateGame;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RequestMapping("/Bibze/Partie")
@RequiredArgsConstructor
@RestController
public class Partie_Controler {

    @Autowired
    private final PartieTeamServiceImpl partieTeamService;

    @Autowired
    private final PartieServiceImpl partieService;

    @PostMapping(path = "/save")
    public ResponseEntity<Partie> CreatePartie(@RequestBody PArtieCreateDto pArtieCreateDto){

        Partie partie = new Partie(0L, LocalDate.now(),LocalDate.now(), pArtieCreateDto.getNbr_manche(), stateGame.Started,pArtieCreateDto.getTeams(),null);
        return partieService.savePartie(partie);

    };

}
