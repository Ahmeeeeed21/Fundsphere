package tn.esprit.fundsphere.Entities.CrediMangment;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tranche")
public class Tranche {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idTranche;
    boolean status=false;

    //@NotNull(message = "The Limit date cannot be null.")
    Date dateLimit ;

    //@Positive(message = "the amount must be positif")
    float amount ;

   // @Positive(message = "the rateRecovery must be positif")
    float rateRecovery ;

    @ManyToOne
    @JsonIgnore
    private Credit credit ;
}
