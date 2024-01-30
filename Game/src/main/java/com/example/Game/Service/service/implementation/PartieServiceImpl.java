package com.example.Game.Service.service.implementation;


import com.example.Game.Dto.Partie.PartieDto;
import com.example.Game.Dto.Partie.PartieTeamDto;
import com.example.Game.Model.Partie;
import com.example.Game.Repo.PartieRepo;
import com.example.Game.Service.service.PartieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("partieService")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PartieServiceImpl implements PartieService {


    @Autowired
    private final PartieRepo partieRepo;

    @Override
    public ResponseEntity<Partie> savePartie(Partie partie) {
        partieRepo.save(partie);
        return new ResponseEntity<Partie>(partie, HttpStatus.CREATED);
    }

    @Override
    public PartieDto updatePArtie(Long id) {
        return null;
    }

    @Override
    public void deletePartie(Long id) {

    }

    @Override
    public PartieTeamDto findById(Long id) {
        return null;
    }
}
