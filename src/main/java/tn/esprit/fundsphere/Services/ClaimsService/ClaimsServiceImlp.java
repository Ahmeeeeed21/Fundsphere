package tn.esprit.fundsphere.Services.ClaimsService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.fundsphere.Entities.ClaimsManagment.Claims;
import tn.esprit.fundsphere.Repositories.ClaimsRepository.ClaimsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClaimsServiceImlp implements IClaimsService{

    private ClaimsRepository claimsRepository ;

    @Override
    public Claims addClaims(Claims claims) {
        return claimsRepository.save(claims);
    }

    @Override
    public void deleteClaims(Long idClaim) {
        claimsRepository.deleteById(idClaim);
    }

    @Override
    public Claims updateClaims(Claims claims) {
        return claimsRepository.save(claims);
    }

    @Override
    public List<Claims> getAllClaims() {
        return claimsRepository.findAll();
    }

    @Override
    public Claims getCClaims(Long idClaim) {
        return claimsRepository.findById(idClaim).get();
    }
}
