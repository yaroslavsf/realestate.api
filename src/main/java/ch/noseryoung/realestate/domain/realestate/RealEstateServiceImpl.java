package ch.noseryoung.realestate.domain.realestate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealEstateServiceImpl implements RealEstateService{
    private RealEstateRepository realEstateRepository;
    @Autowired
    public RealEstateServiceImpl(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }
}
