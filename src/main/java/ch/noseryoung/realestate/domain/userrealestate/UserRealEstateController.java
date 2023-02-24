package ch.noseryoung.realestate.domain.userrealestate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userrealestate")
public class UserRealEstateController {
    private UserRealEstateService userRealEstateService;

    @Autowired
    public UserRealEstateController(UserRealEstateService userRealEstateService) {
        this.userRealEstateService = userRealEstateService;
    }
}
