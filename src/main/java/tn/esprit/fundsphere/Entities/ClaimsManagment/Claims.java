package tn.esprit.fundsphere.Entities.ClaimsManagment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.fundsphere.Entities.UserManagment.User;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "claims")
public class Claims {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idClaim ;

    @NotNull(message = "The answer date cannot be null.")
    Date dateCreationClaim ;

    @NotBlank(message = "The content cannot be empty.")
    @Size(min =8 , message = "The content must be at least 8 characters long.")
    String Content ;

    @NotBlank(message = "The answer cannot be empty.")
    @Size(min =8 , message = "The answer must be at least 8 characters long.")
    String answer ;

    @NotNull(message = "The answer date cannot be null.")
    Date dateAnswer ;

    @ManyToOne
    @JsonIgnore
    private User user ;
}
