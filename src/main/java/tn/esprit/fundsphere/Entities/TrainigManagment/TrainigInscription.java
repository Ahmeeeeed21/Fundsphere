package tn.esprit.fundsphere.Entities.TrainigManagment;

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
@Table(name = "trainigInscription")
public class TrainigInscription {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idTi ;
    Date DateInscription ;
    String feedback ;
}
