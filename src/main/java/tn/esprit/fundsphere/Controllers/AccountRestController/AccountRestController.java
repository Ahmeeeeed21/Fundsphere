package tn.esprit.fundsphere.Controllers.AccountRestController;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.fundsphere.Entities.AccountManagment.Account;
import tn.esprit.fundsphere.Services.AccountService.IAccountService;
import tn.esprit.fundsphere.Services.CreditService.CreditServiceImpl;
import tn.esprit.fundsphere.Services.CreditService.ICreditService;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountRestController {
    public IAccountService accountService;
    public ICreditService creditService;

    @PostMapping("/add")
    public Account addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @PutMapping("/affecter-credit-a-account/{credit-id}/{idAccount}")
    public void assignCreditToAccount(@PathVariable("credit-id") Long idCredit,
                                       @PathVariable("idAccount") Long idAccount) {
        creditService.assignCreditToAccount(idCredit, idAccount);
    }

    @PutMapping("/desaffecgter-credit-a-account/{credit-id}")
    public void assignCreditToAccount(@PathVariable("credit-id") Long idCredit) {
        creditService.unassignCreditToAccount(idCredit );
    }
}


