package ch.noseryoung.realestate.domain.realestate;

import ch.noseryoung.realestate.domain.users.User;

import java.util.List;
import java.util.UUID;

public interface RealEstateService {
    List<RealEstate> findAll();

    RealEstate findById(UUID id);

    RealEstate save(RealEstate realEstate, User user);

    void deleteById(UUID realestateId);

    RealEstate update(RealEstate realEstate, UUID realestate_id);
}
