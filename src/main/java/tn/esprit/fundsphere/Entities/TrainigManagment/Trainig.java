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
@Table(name = "trainig")
public class Trainig {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idTrain;
    String title;
    String description;
    Date startDate;
    Date finishDate;
    int maxCapacity;
}
