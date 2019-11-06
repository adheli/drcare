package ie.ait.bteam.drcare.rest.dto;

import ie.ait.bteam.drcare.data.model.Prescription;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 06-Nov-2019
 */
public class OtherMedicalStaffDTO extends UserDTO implements Comparable<OtherMedicalStaffDTO> {
    @Setter
    @Getter
    private List<Prescription> prescriptions;

    @Override
    public int compareTo(OtherMedicalStaffDTO otherMedicalStaffDTO) {
        if (otherMedicalStaffDTO.getId().compareTo(this.getId()) == 0)
            return otherMedicalStaffDTO.getName().compareTo(this.getName());
        else return otherMedicalStaffDTO.getId().compareTo(this.getId());
    }
}
