package com.preAceleracionAlkemy.preAceleracion.controller;

import com.preAceleracionAlkemy.preAceleracion.dto.request.CharacterDtoReq;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoDetails;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoEdit;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoList;
import com.preAceleracionAlkemy.preAceleracion.dto.response.CharacterDtoRes;
import com.preAceleracionAlkemy.preAceleracion.service.CharacterService;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    // == GET ==		
    @GetMapping()
    public ResponseEntity<List<CharacterDtoList>> getCharacters(@RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) Set<Long> idMovie) {

        List<CharacterDtoList> characterDto = characterService.getByFilters(name, age, weight, idMovie);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(characterDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<CharacterDtoDetails> getCharacterDetailsById(@PathVariable Long id) {
        CharacterDtoDetails characterDetails = characterService.getCharacterDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(characterDetails);
    }

    // == GET ==
    // == POST ==	
    @PostMapping()
    public ResponseEntity<CharacterDtoRes> save(@Valid @RequestBody CharacterDtoReq newCharacter) {
        CharacterDtoRes createdChar = characterService.save(newCharacter);
        return ResponseEntity.status(HttpStatus.OK).body(createdChar);
    }

    // == POST ==	
    // == PUT ==	
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDtoEdit> editCharacter(@PathVariable Long id, @Valid @RequestBody CharacterDtoReq editCharacter) {
        CharacterDtoEdit editedChar = characterService.editCharacterById(id, editCharacter);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedChar);
    }
    // == PUT ==
    // == DELETE ==	

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        characterService.deleteCharacterById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    // == DELETE ==
}
