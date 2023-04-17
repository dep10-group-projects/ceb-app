package lk.ijse.dep10.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CebAssignments {
    String registrationNumber;
    String assignedLocation;
    String type;
    Date assignedDate;
    String comments;

    public String getAssignedDateString(){
        return assignedDate.toString();
    }
}
