
package com.preAceleracionAlkemy.preAceleracion.controller;

import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import com.preAceleracionAlkemy.preAceleracion.service.CharacterService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("characters")
public class CharacterController {
    
      @Autowired
      private CharacterService characterService;
    
    
    	// == GET ==		
	@GetMapping("/all")
	public ResponseEntity<List<CharacterDto>> getBasicCharacters(){
		List<CharacterDto> charDTO = characterService.getCharacterList();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(charDTO);
	}
		
	@GetMapping("/details/{id}")
	public ResponseEntity<CharacterDto> getDetailsById(@PathVariable Long id){
		CharacterDto charDetails = characterService.getCharacterDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(charDetails);
	}
	
	// == POST ==	
	@PostMapping
	public ResponseEntity<CharacterDto> postNewCharacter(@RequestBody CharacterDto newChar){
		CharacterDto createdChar = characterService.saveNewCharacter(newChar);
		return ResponseEntity.status(HttpStatus.OK).body(createdChar);
	}
	
	// == PUT ==	
	@PutMapping("/{id}")
	public ResponseEntity<CharacterDetailsDto> editCharacter(@PathVariable Long id, @RequestBody CharacterDetailsDto charToEdit){
		CharacterDetailsDto editedChar = characterService.editCharacterById(id, charToEdit);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedChar);
	}
	
	// == DELETE ==	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		characterService.deleteCharacterById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
//	// == FILTERS ==
//	@GetMapping()
//	public ResponseEntity<List<CharacterDTO>> getDetailsByFilters(
//				@RequestParam(required = false) String name,
//				@RequestParam(required = false) Integer age,
//				@RequestParam(required = false) Set<Long> movies
//			){
//		List<CharacterDTO> charList = charServ.getByFilters(name, age, movies);
//		return ResponseEntity.status(HttpStatus.OK).body(charList);
//	}
    
}
