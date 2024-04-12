package tn.esprit.fundsphere.Controllers.CreditRestController;


import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.fundsphere.Entities.ClaimsManagment.Claims;
import tn.esprit.fundsphere.Entities.CrediMangment.Tranche;
import tn.esprit.fundsphere.Entities.TransactionManagment.Transaction;
import tn.esprit.fundsphere.Services.CreditService.TrancheServiceImpl;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tranche")
public class TrancheRestController {

    public TrancheServiceImpl trancheService;

    @PostMapping(path = "/add-tranche")
    public Tranche addTranche(@RequestBody Tranche claims) {
        return trancheService.addTranche(claims);
    }

    @GetMapping("/show-tranche")
    public List<Tranche> getAllTranches() {
        List<Tranche> listTranches = trancheService.getAllTranches();
        return listTranches;
    }

    @DeleteMapping(path = "/delete-tranche/{id}")
    public void deleteTranche(@PathVariable("id") Long idTranche) {
        trancheService.deleteTranche(idTranche);
    }


    @PutMapping(path = "/update-tranche")
    public Tranche updateTranche(@RequestBody Tranche t) {

        Tranche tranches = trancheService.updateTranche(t);
        return tranches;
    }

    @GetMapping("/verif-tranche")
    public void verifyTrancheAmountInAccount() {
        trancheService.verifyTrancheAmountInAccount();
    }

}

