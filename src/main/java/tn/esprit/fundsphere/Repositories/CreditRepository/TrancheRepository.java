package tn.esprit.fundsphere.Repositories.CreditRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.fundsphere.Entities.CrediMangment.Credit;
import tn.esprit.fundsphere.Entities.CrediMangment.Tranche;

import java.util.List;

public interface TrancheRepository extends JpaRepository<Tranche,Long> {
    List<Tranche> findByCredit(Credit credit ) ;
    List<Tranche> findByStatus(boolean status);
}
