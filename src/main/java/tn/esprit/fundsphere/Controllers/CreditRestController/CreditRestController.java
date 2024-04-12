package tn.esprit.fundsphere.Controllers.CreditRestController;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.fundsphere.Entities.ClaimsManagment.Claims;
import tn.esprit.fundsphere.Entities.CrediMangment.Credit;
import tn.esprit.fundsphere.Services.CreditService.CreditServiceImpl;
import tn.esprit.fundsphere.Services.CreditService.TrancheServiceImpl;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/credit")
public class CreditRestController {

    public CreditServiceImpl creditService ;
    public TrancheServiceImpl trancheService ;

   /* @PostMapping(path = "/add-credit")
    public Credit addCredit (@RequestBody Credit credit)
    {
        return creditService.addCredit(credit);
    }*/
   @PostMapping(path = "/add-credit")
   public ResponseEntity<Credit> addCredit(@Valid @RequestBody Credit credit, BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           // Gérer les erreurs de validation
           return ResponseEntity.badRequest().build();
       }

       Credit addedCredits = creditService.addCredit(credit);
       return ResponseEntity.ok(addedCredits);
   }
    @GetMapping("/show-credits")
    public List<Credit> getAllCredits() {
        List<Credit> listCredits = creditService.getAllCredits();
        return listCredits;
    }

  /*  @DeleteMapping(path = "/delete-credit/{id}")
    public void deleteCredit (@PathVariable ("id") Long idCredit)
    {
        creditService.deleteCredit(idCredit);
    }*/
  @DeleteMapping(path = "/delete-credit/{id}")
  public ResponseEntity<Void> deleteCredit(@PathVariable("id") @Positive Long idCredit) {
      if (idCredit == null) {
          return ResponseEntity.badRequest().build();
      }

      creditService.deleteCredit(idCredit);
      return ResponseEntity.ok().build();
  }

   /* @PutMapping(path = "/update-credit")
    public Credit updateCredit(@RequestBody Credit cr)
    {

        Credit credit = creditService.updateCredit(cr);
        return credit ;
    }*/

    @GetMapping(path= "/verifCondition/{idCredit}")
    public String verifCondition(Credit credit,@PathVariable int idCredit){
        return creditService.verifCondition(credit,idCredit);
    }


   @PutMapping(path = "/update-credit")
   public ResponseEntity<Credit> updateStateCredit(@Valid @RequestBody Credit cr, BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           // Gérer les erreurs de validation
           return ResponseEntity.badRequest().build();
       }

       Credit credit = creditService.updateStateCredit(cr);
       return ResponseEntity.ok(credit);
   }

    @PutMapping("/affecter-tranche-a-credit/{tranche-id}/{idCredit}")
    public void assignTranchesToCredit(@PathVariable("tranche-id") Long idTranche,
                                      @PathVariable("idCredit") Long idCredit) {
        trancheService.assignTranchesToCredit(idTranche, idCredit);
    }

    @PutMapping("/desaffecgter-bloc-a-idFoyer/{tranche-id}/{idCredit}")
    public void dessignerTrancheToCredit(@PathVariable("tranche-id") Long idTranche,
                                         @PathVariable("idCredit") Long idCredit) {
        trancheService.dessignerTrancheToCredit(idTranche );
    }
}
