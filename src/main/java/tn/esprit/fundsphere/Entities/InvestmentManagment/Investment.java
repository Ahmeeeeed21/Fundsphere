package tn.esprit.fundsphere.Entities.InvestmentManagment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.fundsphere.Entities.TransactionManagment.Transaction;
import tn.esprit.fundsphere.Entities.UserManagment.TypeUser;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "investment")
public class Investment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idInvest;
    int ownerId;
    float amountInv;
    Boolean state;
    String description ;
    @Enumerated(EnumType.STRING)
    TypeInvest typeI;

   /* @OneToMany(mappedBy = "investment")
    private List<Transaction> transactions;*/

}
