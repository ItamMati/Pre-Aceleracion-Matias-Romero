package com.preAceleracionAlkemy.preAceleracion.service.serviceImplements;

import com.preAceleracionAlkemy.preAceleracion.mapper.CharacterMapper;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterFilterDto;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import com.preAceleracionAlkemy.preAceleracion.repository.CharacterRepository;
import com.preAceleracionAlkemy.preAceleracion.repository.specification.CharacterSpecification;
import com.preAceleracionAlkemy.preAceleracion.service.CharacterService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    // Repository:
    @Autowired
    private CharacterRepository characterRepository;

    // Mapper:
    @Autowired
    private CharacterMapper characterMapper;

//     Specifications:
    @Autowired
    private CharacterSpecification characterSpecification;

    // == GET ==
    @Override
    public List<CharacterDto> getCharacterList() {

        List<CharacterEntity> characters = characterRepository.findAll();

        List<CharacterDto> characterDto = characterMapper.listCharacterEntityToListCharacterDto(characters);

        return characterDto;
    }

    @Override
    public CharacterDetailsDto getCharacterDetails(Long id) {
        CharacterEntity dbChar = this.handleFindById(id);
        CharacterDetailsDto characterDetailsDto = characterMapper.characterEntityToCharacterDetailsDto(dbChar);
        return characterDetailsDto;
    }

    // == POST ==
    @Override
    public CharacterDetailsDto save(CharacterDetailsDto characterDetailsDto) {
        CharacterEntity newCharacter = characterMapper.characterDetailsDtoToEntity(characterDetailsDto);
        CharacterEntity savedEntity = characterRepository.save(newCharacter);
        CharacterDetailsDto savedChar = characterMapper.characterEntityToCharacterDetailsDto(savedEntity);
        return savedChar;
    }

    // == DELETE ==
    @Override
    public void deleteCharacterById(Long id) {
        characterRepository.deleteById(id);
    }

    // == PUT ==
    @Override
    public CharacterDetailsDto editCharacterById(Long id, CharacterDetailsDto charToEdit) {
        CharacterEntity savedChar = this.handleFindById(id);
        savedChar.setImageUrl(charToEdit.getImageUrl());
        savedChar.setName(charToEdit.getName());
        savedChar.setAge(charToEdit.getAge());
        savedChar.setWeight(charToEdit.getWeight());
        savedChar.setHistory(charToEdit.getHistory());
        CharacterEntity editedChar = characterRepository.save(savedChar);
        CharacterDetailsDto resultDTO = characterMapper.characterEntityToCharacterDetailsDto(editedChar);
        return resultDTO;
    }

    // == FILTERS ==
    @Override
    public List<CharacterDto> getByFilters(String name, Integer age, Double weight, Set<Long> movies) {
        CharacterFilterDto characterFilterDto = new CharacterFilterDto(name, age, weight, movies);

        List<CharacterEntity> entityList = characterRepository.findAll(
                where((characterSpecification.getByName(characterFilterDto)).
                        and(characterSpecification.getByAge(characterFilterDto).
                                and(characterSpecification.getByWeight(characterFilterDto)))));
//                                        and(characterSpecification.getByMovieId(characterFilterDto))))));

        List<CharacterDto> resultDTO = characterMapper.listCharacterEntityToListCharacterDto(entityList);
        return resultDTO;
    }

    // == ERROR HANDLING ==
    public CharacterEntity handleFindById(Long id) {
        Optional<CharacterEntity> toBeFound = characterRepository.findById(id);
        if (!toBeFound.isPresent()) {
//            throw new ParamNotFound("No Character for id: " + id);
        }
        return toBeFound.get();
    }

}
