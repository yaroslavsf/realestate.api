package ch.noseryoung.realestate.domain.userrealestate;

import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.users.User;

import java.util.List;
import java.util.UUID;

public interface UserRealEstateService {
    List<UserRealEstate> getAllByRealEstateId(UUID id);

    UserRealEstate save(User u, RealEstate r);

    List<UserRealEstate> getAllByUserId(UUID id);

    UserRealEstate save(UserRealEstate userRealEstate);

    UserRealEstate findById(UUID realestateId);

    UserRealEstate declineAllBesides(RealEstate byId, User id);

//    boolean checkForOwner(UUID ownerId);
}
