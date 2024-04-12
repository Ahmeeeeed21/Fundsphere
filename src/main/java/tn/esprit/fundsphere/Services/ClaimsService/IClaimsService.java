package tn.esprit.fundsphere.Services.ClaimsService;

import tn.esprit.fundsphere.Entities.ClaimsManagment.Claims;
import tn.esprit.fundsphere.Entities.CrediMangment.Credit;

import java.util.List;

public interface IClaimsService {
    public Claims addClaims(Claims claims);
    public void deleteClaims(Long idClaim);
    public Claims updateClaims(Claims claims);
    public List<Claims> getAllClaims();
    public Claims getCClaims(Long idClaim);
}
