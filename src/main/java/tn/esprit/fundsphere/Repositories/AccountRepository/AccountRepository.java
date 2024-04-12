package tn.esprit.fundsphere.Repositories.AccountRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.fundsphere.Entities.AccountManagment.Account;
import tn.esprit.fundsphere.Entities.ClaimsManagment.Claims;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
