package com.preAceleracionAlkemy.preAceleracion.controller;

import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import com.preAceleracionAlkemy.preAceleracion.service.CharacterService;
import java.util.List;
import java.util.Set;
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
    @GetMapping("/list")
    public ResponseEntity<List<CharacterDto>> getCharacters(@RequestParam(required = false) String name,
                                                            @RequestParam(required = false) Integer age,
                                                            @RequestParam(required = false) Double weight,
                                                            @RequestParam(required = false) Set<Long> idMovie) {

        List<CharacterDto> characterDto = characterService.getByFilters(name, age, weight, idMovie);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(characterDto);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CharacterDetailsDto> getCharacterDetailsDtoById(@PathVariable Long id) {
        CharacterDetailsDto characterDetails = characterService.getCharacterDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(characterDetails);
    }

    // == POST ==	
    @PostMapping
    public ResponseEntity<CharacterDetailsDto> save(@RequestBody CharacterDetailsDto newCharacter) {
        CharacterDetailsDto createdChar = characterService.save(newCharacter);
        return ResponseEntity.status(HttpStatus.OK).body(createdChar);
    }

    // == PUT ==	
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDetailsDto> editCharacter(@PathVariable Long id, @RequestBody CharacterDetailsDto charToEdit) {
        CharacterDetailsDto editedChar = characterService.editCharacterById(id, charToEdit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedChar);
    }

    // == DELETE ==	
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        characterService.deleteCharacterById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
