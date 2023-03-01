package ch.noseryoung.realestate.domain.userrealestate;

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

    @GetMapping("/get_all_by_realestate_id/{realestate_id}")
    public ResponseEntity<List<UserRealEstateDTO.RetrieveForRealEstate>> retrieveByRealEstateId(@PathVariable(value="realestate_id") UUID id) {
         List<UserRealEstate> userRealEstates = userRealEstateService.getAllByRealEstateId(id);
         List<UserRealEstateDTO.RetrieveForRealEstate> userRealEstateDTOS = new ArrayList<>();

         userRealEstates.forEach(
                 userRealEstate -> userRealEstateDTOS.add(userRealEstateMapper.toRetrieveForRealEstate(userRealEstate))
         );

        return new ResponseEntity<>(userRealEstateDTOS, HttpStatus.OK);
    }

    @GetMapping("/get_all_by_user_id/{user_id}")
    public ResponseEntity<List<UserRealEstateDTO.RetrieveForUser>> retrieveByUserId(@PathVariable(value="user_id") UUID id) {
        List<UserRealEstate> userRealEstates = userRealEstateService.getAllByUserId(id);
        List<UserRealEstateDTO.RetrieveForUser> userRealEstateDTOS = new ArrayList<>();

        userRealEstates.forEach(
                userRealEstate -> userRealEstateDTOS.add(userRealEstateMapper.toRetrieveForUser(userRealEstate))
        );

        return new ResponseEntity<>(userRealEstateDTOS, HttpStatus.OK);
    }

    @PostMapping("/apply_for/{realestate_id}/by_user/{user_id}")
    public ResponseEntity<UserRealEstateDTO.Create> create(@PathVariable(value="realestate_id") UUID realestate_id, @PathVariable(value="user_id") UUID user_id){
        if (userService.userIsAgent(user_id)) throw new RuntimeException("user has no rights as client");
        User u = userService.findById(user_id);
        RealEstate r = realEstateService.findById(realestate_id);

        return new ResponseEntity<>(userRealEstateMapper.toCreateDTO(userRealEstateService.save(u, r)) ,HttpStatus.OK);
    }

    @GetMapping("/accept/{realestate_id}/by_owner/{owner_id}/for_user/{user_id}")
    public ResponseEntity<UserRealEstateDTO.RetrieveForRealEstate> accept(@PathVariable(value="realestate_id") UUID realestate_id, @PathVariable(value="user_id") UUID user_id, @PathVariable(value="owner_id") UUID owner_id){
//TODO: accept the application and decline all other on this realestate

        //checking
//        UserRealEstate userRealEstate = userRealEstateService.findById();
//        if (!userRealEstateService.checkForOwner(owner_id, userRealEstate)) throw new RuntimeException("provided owner is wrong");
//        if (!userRealEstateService.checkForApplication(userService.findById(user_id), realestate_id)) throw new RuntimeException("provided client is wrong");

        //declining all other applications
//        userRealEstateService.declineAllBesides(realEstateService.findById(realestate_id), userService.findById(user_id));

        return new ResponseEntity<>(userRealEstateMapper.toRetrieveForRealEstate(userRealEstateService.save(userRealEstate)) ,HttpStatus.OK);
    }

}
