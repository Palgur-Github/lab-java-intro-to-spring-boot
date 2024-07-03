package ironhack.schl.Lab4_02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private Integer patientId;
    private String name;
    private String dateOfBirth;

   @ManyToOne
    private Doctor doctor;

    public Patient(Integer patientId, String name, String dateOfBirth){
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return patientId;
    }

    public String getPatient() {
        return name;
    }

    public Integer getAdmittedByDoctorId() {
        return doctor.getId();
    }
}
