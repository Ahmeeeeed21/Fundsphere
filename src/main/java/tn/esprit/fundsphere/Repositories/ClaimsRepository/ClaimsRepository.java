package tn.esprit.fundsphere.Repositories.ClaimsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.fundsphere.Entities.ClaimsManagment.Claims;

public interface ClaimsRepository extends JpaRepository<Claims,Long> {
}
