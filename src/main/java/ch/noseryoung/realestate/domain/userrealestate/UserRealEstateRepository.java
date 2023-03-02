package ch.noseryoung.realestate.domain.userrealestate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRealEstateRepository  extends JpaRepository<UserRealEstate, UUID> {
    List<UserRealEstate> findAllByRealEstateId(UUID id);

    List<UserRealEstate> findAllByUserId(UUID id);
}