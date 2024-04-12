package tn.esprit.fundsphere.Entities.InvestmentManagment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "investorWin")
public class InvestorWin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idInvestW;
    double amountInv;
    Date dateInvW ;
    Float ROI;

}
