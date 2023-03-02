package ch.noseryoung.realestate.domain.userrealestate;

import ch.noseryoung.realestate.domain.enums.RealEstateStatus;
import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.realestate.RealEstateService;
import ch.noseryoung.realestate.domain.userrealestate.dto.UserRealEstateDTO;
import ch.noseryoung.realestate.domain.userrealestate.dto.UserRealEstateMapper;
import ch.noseryoung.realestate.domain.users.User;
import ch.noseryoung.realestate.domain.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/userrealestate")
public class UserRealEstateController {
    private UserRealEstateService userRealEstateService;
    private UserService userService;
    private RealEstateService realEstateService;
    private UserRealEstateMapper userRealEstateMapper;

    @Autowired
    public UserRealEstateController(UserRealEstateService userRealEstateService, UserService userService, RealEstateService realEstateService, UserRealEstateMapper userRealEstateMapper) {
        this.userRealEstateService = userRealEstateService;
        this.userService = userService;
        this.realEstateService = realEstateService;
        this.userRealEstateMapper = userRealEstateMapper;
    }

    @GetMapping("/all/by/{realestate_id}")
    public ResponseEntity<List<UserRealEstateDTO.RetrieveForRealEstate>> retrieveByRealEstateId(@PathVariable(value="realestate_id") UUID id) {
        //map userrealestates to dtos
        List<UserRealEstate> userRealEstates = userRealEstateService.getAllByRealEstateId(id);
         List<UserRealEstateDTO.RetrieveForRealEstate> userRealEstateDTOS = new ArrayList<>();
         userRealEstates.forEach(
                 userRealEstate -> userRealEstateDTOS.add(userRealEstateMapper.toRetrieveForRealEstate(userRealEstate))
         );

        return new ResponseEntity<>(userRealEstateDTOS, HttpStatus.OK);
    }

    @GetMapping("/all/by/{user_id}")
    public ResponseEntity<List<UserRealEstateDTO.RetrieveForUser>> retrieveByUserId(@PathVariable(value="user_id") UUID id) {
        //map userrealestates to dtos
        List<UserRealEstate> userRealEstates = userRealEstateService.getAllByUserId(id);
        List<UserRealEstateDTO.RetrieveForUser> userRealEstateDTOS = new ArrayList<>();
        userRealEstates.forEach(
                userRealEstate -> userRealEstateDTOS.add(userRealEstateMapper.toRetrieveForUser(userRealEstate))
        );

        return new ResponseEntity<>(userRealEstateDTOS, HttpStatus.OK);
    }

    @PostMapping("/apply/{realestate_id}/by/{user_id}")
    public ResponseEntity<UserRealEstateDTO.Create> create(@PathVariable(value="realestate_id") UUID realestate_id, @PathVariable(value="user_id") UUID user_id){
        //check on rights
        if (userService.userIsAgent(user_id)) throw new RuntimeException("user has no rights as client");

        User userApply = userService.findById(user_id);
        RealEstate realEstateApply = realEstateService.findById(realestate_id);

        return new ResponseEntity<>(userRealEstateMapper.toCreateDTO(userRealEstateService.save(userApply, realEstateApply)) ,HttpStatus.CREATED);
    }

    @GetMapping("/accept/{realestate_id}/by/{owner_id}/for/{user_id}")
    public ResponseEntity<UserRealEstateDTO.RetrieveForRealEstate> accept(@PathVariable(value="realestate_id") UUID realestate_id, @PathVariable(value="user_id") UUID user_id, @PathVariable(value="owner_id") UUID owner_id){
        //res
        UserRealEstate applicationToReturn = null;

        RealEstate realEstate = realEstateService.findById(realestate_id);
        List<UserRealEstate> applicationsOnRealEstate = realEstate.getUserRealEstates();
        User userToAccept = userService.findById(user_id);
        //logic for accepting/declining
        for (var app: applicationsOnRealEstate) {
            if (app.getUser().equals(userToAccept)) {
                app.setStatus(RealEstateStatus.ACCEPTED);
                applicationToReturn = app;
            } else {
                app.setStatus(RealEstateStatus.DECLINED);
            }
        }

        if (applicationToReturn == null) throw new RuntimeException("error while accepting application");
        return new ResponseEntity<>(userRealEstateMapper.toRetrieveForRealEstate(userRealEstateService.save(applicationToReturn)) ,HttpStatus.OK);
    }


    @GetMapping("/decline/{realestate_id}/by/{owner_id}/for/{user_id}")
    public ResponseEntity<UserRealEstateDTO.RetrieveForRealEstate> decline(@PathVariable(value="realestate_id") UUID realestate_id, @PathVariable(value="user_id") UUID user_id, @PathVariable(value="owner_id") UUID owner_id){
       //res
        UserRealEstate applicationToReturn = null;
        RealEstate realEstate = realEstateService.findById(realestate_id);
        List<UserRealEstate> applicationsOnRealEstate = realEstate.getUserRealEstates();
        User userToDecline = userService.findById(user_id);
        //logic for accepting/declining
        for (var app: applicationsOnRealEstate) {
            if (app.getUser().equals(userToDecline)) {
                app.setStatus(RealEstateStatus.DECLINED);
                applicationToReturn = app;
            }
        }

        if (applicationToReturn == null) throw new RuntimeException("error while declining application");
        return new ResponseEntity<>(userRealEstateMapper.toRetrieveForRealEstate(userRealEstateService.save(applicationToReturn)) ,HttpStatus.OK);
    }
}
