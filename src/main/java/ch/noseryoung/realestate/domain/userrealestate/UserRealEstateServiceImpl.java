package ch.noseryoung.realestate.domain.userrealestate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRealEstateServiceImpl implements UserRealEstateService{
    private UserRealEstateRepository userRealEstateRepository;
    @Autowired
    public UserRealEstateServiceImpl(UserRealEstateRepository userRealEstateRepository) {
        this.userRealEstateRepository = userRealEstateRepository;
    }
}
