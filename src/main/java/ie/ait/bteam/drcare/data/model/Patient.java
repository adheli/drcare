package ie.ait.bteam.drcare.data.model;

import ie.ait.bteam.drcare.rest.dto.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Patient extends Base implements Serializable {

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "user_allergy", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "allergy_id"))
    private List<Allergy> allergies;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "user_prescription", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "prescription_id"))
    private List<Prescription> prescriptions;

    public Patient() {
       setUserType(UserType.PATIENT.name());
    }
}
