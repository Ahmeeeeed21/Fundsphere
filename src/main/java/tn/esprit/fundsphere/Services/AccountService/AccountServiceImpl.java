package tn.esprit.fundsphere.Services.AccountService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.fundsphere.Entities.AccountManagment.Account;
import tn.esprit.fundsphere.Repositories.AccountRepository.AccountRepository;
import tn.esprit.fundsphere.Repositories.CreditRepository.CreditRepository;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService{
  private AccountRepository accountRepository ;
  private CreditRepository creditRepository ;


    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }
}
