package ch.noseryoung.realestate.domain.realestate;

import ch.noseryoung.realestate.domain.realestate.dto.RealEstateDTO;
import ch.noseryoung.realestate.domain.realestate.dto.RealEstateMapper;
import ch.noseryoung.realestate.domain.users.User;
import ch.noseryoung.realestate.domain.users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/realestate")
public class RealEstateController {
    private RealEstateService realEstateService;
    private UserService userService;
    private RealEstateMapper realEstateMapper;

    @Autowired
    public RealEstateController(RealEstateService realEstateService, UserService userService, RealEstateMapper realEstateMapper) {
        this.realEstateService = realEstateService;
        this.userService = userService;
        this.realEstateMapper = realEstateMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RealEstateDTO>> retrieveAll() {
        //map list of realestate to dto
        List<RealEstate> realEstates = realEstateService.findAll();
        List <RealEstateDTO> realEstateDTOS = new ArrayList<>();
        realEstates.forEach(realEstate -> realEstateDTOS.add(realEstateMapper.toDTO(realEstate)));

        return new ResponseEntity<>(realEstateDTOS , HttpStatus.OK);
    }

    @GetMapping("/by/{id}")
    public ResponseEntity<RealEstateDTO.RetrieveFullyDressed> retrieveById(@PathVariable(value="id") UUID id) {
        return new ResponseEntity<>(realEstateMapper.toRetrieveFullyDressedDTO(realEstateService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/by/{user_id}")
    public ResponseEntity<RealEstateDTO.RetrieveFullyDressed> create(@PathVariable(value="user_id") UUID user_id, @Valid @RequestBody RealEstateDTO realEstateCreateDto) {
        //check user on null and on rights
        User user = userService.findById(user_id);
        if (user == null) throw new NoSuchElementException("no user found on create realestate");
        if (!userService.userIsAgent(user_id)) throw new RuntimeException("user has no rights to create realestate");

        return new ResponseEntity<>(realEstateMapper.toRetrieveFullyDressedDTO(realEstateService.save(realEstateMapper.fromDTO(realEstateCreateDto), user)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{realestate_id}/by/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable(value="realestate_id") UUID realestate_id, @PathVariable(value="user_id") UUID user_id){
        //check owner on rights
        if (!userService.userIsAgent(user_id)) throw new RuntimeException("user has no rights as agent");
        if (!realEstateService.findById(realestate_id).getUser().getId().equals(user_id)) throw new RuntimeException("user has no rights to delete this realestate");
        realEstateService.deleteById(realestate_id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{realestate_id}/by/{user_id}")
    public ResponseEntity<RealEstateDTO.RetrieveFullyDressed> replace(@Valid @RequestBody RealEstateDTO realEstateDTO, @PathVariable(value="realestate_id") UUID realestate_id, @PathVariable(value="user_id") UUID user_id) {
        //check owner on rights
        if (!userService.userIsAgent(user_id)) throw new RuntimeException("user has no rights as agent");
        if (!realEstateService.findById(realestate_id).getUser().getId().equals(user_id)) throw new RuntimeException("user has no rights to delete this realestate");

        return new ResponseEntity<>(realEstateMapper.toRetrieveFullyDressedDTO(realEstateService.update(realEstateMapper.fromDTO(realEstateDTO), realestate_id)), HttpStatus.OK);
    }

    @GetMapping("/search/{canton}")
    public ResponseEntity<List<RealEstateDTO>> searchByCanton(@PathVariable(value="canton") String canton_criteria) {
        //map realestates to dtos
        List<RealEstate> foundRealEstates = realEstateService.searchByCanton(canton_criteria);
        List<RealEstateDTO> resultToReturn = new ArrayList<>();
        foundRealEstates.forEach(realEstate -> resultToReturn.add(realEstateMapper.toDTO(realEstate)));

        return new ResponseEntity<>(resultToReturn, HttpStatus.FOUND);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<RealEstateDTO>> searchByName(@PathVariable(value="name")  String name_criteria) {
        //map realestates to dtos
        List<RealEstate> foundRealEstates = realEstateService.searchByName(name_criteria);
        List<RealEstateDTO> resultToReturn = new ArrayList<>();
        foundRealEstates.forEach(realEstate -> resultToReturn.add(realEstateMapper.toDTO(realEstate)));

        return new ResponseEntity<>(resultToReturn, HttpStatus.CREATED);
    }
}
