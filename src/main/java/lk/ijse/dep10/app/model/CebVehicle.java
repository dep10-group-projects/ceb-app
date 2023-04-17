package lk.ijse.dep10.app.model;

import jdk.jfr.Threshold;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CebVehicle implements Serializable {
    String registrationNumber;
    String currentLocation;
    String type;
    String chassisNumber;
    String engineNumber;
    int manufacturedYear;
    String comments;

}
