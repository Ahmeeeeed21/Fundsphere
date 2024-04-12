package tn.esprit.fundsphere.Entities.AccountManagment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.fundsphere.Entities.CrediMangment.Credit;
import tn.esprit.fundsphere.Entities.UserManagment.TypeUser;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idAccount;
    int numAccount;
    double balance;
    Long rib;
    LocalDate date;
    @Enumerated(EnumType.STRING)
    TypeAccount typeA;

    @OneToMany(mappedBy = "account")
    private List<Credit>credits;


    public void setCredit(Credit credit) {
    }
}
