package ch.noseryoung.realestate.domain.realestate;

import ch.noseryoung.realestate.domain.userrealestate.UserRealEstate;
import ch.noseryoung.realestate.domain.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class RealEstateServiceImpl implements RealEstateService{
    private RealEstateRepository realEstateRepository;
    @Autowired
    public RealEstateServiceImpl(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    @Override
    public List<RealEstate> findAll() {
        return realEstateRepository.findAll();
    }

    @Override
    public RealEstate findById(UUID id) {
        Optional<RealEstate> realEstate =  realEstateRepository.findById(id);
        if (!realEstate.isPresent()) throw new NoSuchElementException();
        RealEstate r = realEstate.get();
        return r;
    }

    @Override
    public RealEstate save(RealEstate realEstate, User user) {
        realEstate.setUser(user);
        return realEstateRepository.save(realEstate);
    }

    @Override
    public void deleteById(UUID realestateId) {
        realEstateRepository.deleteById(realestateId);
    }

    @Override
    public RealEstate update(RealEstate realEstate, UUID realestate_id) {
        RealEstate r = this.findById(realestate_id);
        List<UserRealEstate> userRealEstates = r.getUserRealEstates();
        User user =  r.getUser();

       r = realEstate;
       r.setId(realestate_id);
       r.setUserRealEstates(userRealEstates);
       r.setUser(user);
        return realEstateRepository.save(r);
    }

    @Override
    public List<RealEstate> searchByCanton(String cantonCriteria) {
        return realEstateRepository.findByCantonLike(cantonCriteria);
    }

    @Override
    public List<RealEstate> searchByName(String nameCriteria) {
        return realEstateRepository.findByNameLike(nameCriteria);
    }
}
