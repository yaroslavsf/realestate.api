package ch.noseryoung.realestate.domain.userrealestate;

import ch.noseryoung.realestate.domain.enums.RealEstateStatus;
import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRealEstateServiceImpl implements UserRealEstateService{
    private UserRealEstateRepository userRealEstateRepository;
    @Autowired
    public UserRealEstateServiceImpl(UserRealEstateRepository userRealEstateRepository) {
        this.userRealEstateRepository = userRealEstateRepository;
    }

    @Override
    public List<UserRealEstate> getAllByRealEstateId(UUID id) {
        return userRealEstateRepository.findAllByRealEstateId(id);
    }

    @Override
    public UserRealEstate save(User u, RealEstate r) {
        UserRealEstate userRealEstate = new UserRealEstate();
        userRealEstate.setUser(u);
        userRealEstate.setRealEstate(r);
        userRealEstate.setStatus(RealEstateStatus.PENDING);
        return userRealEstateRepository.save(userRealEstate);
    }

    @Override
    public List<UserRealEstate> getAllByUserId(UUID id) {
        return userRealEstateRepository.findAllByUserId(id);
    }

    @Override
    public UserRealEstate save(UserRealEstate userRealEstate) {
        return userRealEstateRepository.save(userRealEstate);
    }

    @Override
    public UserRealEstate findById(UUID realestateId) {
        Optional<UserRealEstate> userRealEstate =  userRealEstateRepository.findById(realestateId);
        if (!userRealEstate.isPresent()) throw new NoSuchElementException();
        UserRealEstate r = userRealEstate.get();
        return r;
    }

    @Override
    public UserRealEstate declineAllBesides(RealEstate realEstate, User user) {
       List<UserRealEstate> applications = realEstate.getUserRealEstates();
       UserRealEstate applicationToReturn = null;
        for (var application: applications) {
            if (!application.getUser().equals(user)) {
                application.setStatus(RealEstateStatus.DECLINED);
            } else {
                application.setStatus(RealEstateStatus.ACCEPTED);
                applicationToReturn = application;
            }
        }

        if (applicationToReturn == null) throw new RuntimeException("couldn't accept the application");
        return applicationToReturn;
    }

//    @Override
//    public boolean checkForOwner(UUID ownerId, UserRealEstate userRealEstate) {
//        return (userRealEstate.getUser().getId().equals(ownerId));
//    }
}
