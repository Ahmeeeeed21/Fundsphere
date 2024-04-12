package tn.esprit.fundsphere.Controllers.ClaimsRestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.fundsphere.Entities.ClaimsManagment.Claims;
import tn.esprit.fundsphere.Services.ClaimsService.ClaimsServiceImlp;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/claims")
public class ClaimsRestController {


    public ClaimsServiceImlp claimsService ;

   /* @PostMapping(path = "/add-claims")
    public Claims addClaims (@RequestBody Claims claims)
    {
        return claimsService.addClaims(claims);
    }*/

    @PostMapping(path = "/add-claims")
    public ResponseEntity<Claims> addClaims(@Valid @RequestBody Claims claims, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Gérer les erreurs de validation
            return ResponseEntity.badRequest().build();
        }

        Claims addedClaims = claimsService.addClaims(claims);
        return ResponseEntity.ok(addedClaims);
    }

    @GetMapping("/show-claims")
    public List<Claims> getAllClaims() {
        List<Claims> listClaims = claimsService.getAllClaims();
        return listClaims;
    }
   /* @DeleteMapping(path = "/delete-claims/{id}")
    public void deleteClaims (@PathVariable ("id") Long idClaim)
    {
        claimsService.deleteClaims(idClaim);
    }*/

    @DeleteMapping(path = "/delete-claims/{id}")
    public ResponseEntity<Void> deleteClaims(@PathVariable("id") @Positive Long idClaim) {
        if (idClaim == null) {
            return ResponseEntity.badRequest().build();
        }

        claimsService.deleteClaims(idClaim);
        return ResponseEntity.ok().build();
    }



    /*@PutMapping(path = "/update-claims")
    public Claims updateBloc(@RequestBody Claims c)
    {

        Claims claims = claimsService.updateClaims(c);
        return claims ;
    }*/

    @PutMapping(path = "/update-claims")
    public ResponseEntity<Claims> updateClaims(@Valid @RequestBody Claims c, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Gérer les erreurs de validation
            return ResponseEntity.badRequest().build();
        }

        Claims claims = claimsService.updateClaims(c);
        return ResponseEntity.ok(claims);
    }

}

