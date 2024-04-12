package tn.esprit.fundsphere.Entities.CrediMangment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;
import tn.esprit.fundsphere.Entities.AccountManagment.Account;
import tn.esprit.fundsphere.Entities.UserManagment.User;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idCredit ;

    @NotBlank(message = "The name cannot be empty.")
    @Size(min =3 , message = "The answer must be at least 3 characters long.")
    String nameClient ;

    @NotBlank(message = "The Surname cannot be empty.")
    @Size(min =3 , message = "The Surname must be at least 3 characters long.")
    String surnameClient ;
    boolean investor ;

    @Positive(message = "the salary must be positif")
    float salary ;

    @Positive(message = "the creditAmount must be positif")
    float creditAmount ;

    float interestRate;

    @Positive(message = "the recoverySince must be positif")
    int recoverySince ;

    @NotBlank(message = "The description cannot be empty.")
    @Size(min =2 , message = "The description must be at least 2 characters long.")
    String decision ;

    //@Positive(message = "the amountRecoveryMonth must be positif")
    float amountRecoveryMonth ;

    int state=0 ;

  @ManyToOne
  @JsonIgnore
    private Account account;

  @OneToMany(mappedBy = "credit",fetch = FetchType.EAGER)
    private List<Tranche> tranches;


}
