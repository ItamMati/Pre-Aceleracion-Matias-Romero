package com.preAceleracionAlkemy.preAceleracion.service.serviceImplements;

import com.preAceleracionAlkemy.preAceleracion.mapper.CharacterMapper;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDetailsDtoResponse;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterDto;
import com.preAceleracionAlkemy.preAceleracion.dto.CharacterFilterDto;
import com.preAceleracionAlkemy.preAceleracion.entity.CharacterEntity;
import com.preAceleracionAlkemy.preAceleracion.entity.MovieEntity;
import com.preAceleracionAlkemy.preAceleracion.exception.ParamNotFound;
import com.preAceleracionAlkemy.preAceleracion.repository.CharacterRepository;
import com.preAceleracionAlkemy.preAceleracion.repository.specification.CharacterSpecification;
import com.preAceleracionAlkemy.preAceleracion.service.CharacterService;
import com.preAceleracionAlkemy.preAceleracion.service.MovieService;
import java.util.List;
import static java.util.List.of;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CharacterServiceImpl implements CharacterService {

    //Service
    @Autowired
    private MovieService movieService;

    //Repository:
    @Autowired
    private CharacterRepository characterRepository;

    // Mapper:
    @Autowired
    private CharacterMapper characterMapper;

    //Specifications:
    @Autowired
    private CharacterSpecification characterSpecification;

    // == FILTERS ==
    @Override
    public List<CharacterDto> getByFilters(String name, Integer age, Double weight, Set<Long> movies) {
        CharacterFilterDto characterFilterDto = new CharacterFilterDto(name, age, weight, movies);

        List<CharacterEntity> entityList = characterRepository.findAll(
                where((characterSpecification.getByName(characterFilterDto)).
                        and(characterSpecification.getByAge(characterFilterDto).
                                and(characterSpecification.getByWeight(characterFilterDto).
                                        and(characterSpecification.getByMovieId(characterFilterDto))))));

        List<CharacterDto> resultDTO = characterMapper.listCharacterEntityToListCharacterDto(entityList);
        return resultDTO;
    }

    @Override
    public CharacterDetailsDtoResponse getCharacterDetails(Long id) {
        CharacterEntity dbChar = this.handleFindById(id);
        CharacterDetailsDtoResponse characterDetailsDto = characterMapper.characterEntityToCharacterDetailsDtoResponse(dbChar);
        return characterDetailsDto;
    }

    // == POST ==
    @Override
    public CharacterDetailsDto save(CharacterDetailsDto characterDetailsDto) {

        CharacterEntity newCharacterEntity = characterMapper.characterDetailsDtoToEntity(characterDetailsDto);

        movieService.handleFindById(characterDetailsDto.getIdMovie()).addCharacterToMovie(newCharacterEntity);

        CharacterEntity savedEntity = characterRepository.save(newCharacterEntity);

        CharacterDetailsDto savedChar = characterMapper.characterEntityToCharacterDetailsDto(savedEntity);

        return savedChar;
    }

    // == DELETE ==
    @Override
    public void deleteCharacterById(Long id) {

        CharacterEntity exist = this.handleFindById(id);
        
        characterRepository.deleteById(exist.getId());
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

    // == ERROR HANDLING ==
    public CharacterEntity handleFindById(Long id) {
        Optional<CharacterEntity> toBeFound = characterRepository.findById(id);
        if (!toBeFound.isPresent()) {
            throw new ParamNotFound("No Character for id: " + id);
        }
        return toBeFound.get();
    }

}
