package ie.ait.bteam.drcare.util;

import ie.ait.bteam.drcare.data.model.OtherMedicalStaff;
import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.rest.dto.OtherMedicalStaffDTO;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.dto.UserType;
import org.springframework.stereotype.Component;

/**
 * Created by Pelumi.Oyefeso on 06-Nov-2019
 */
@Component
public class ModelConversionUtil {
    public <T extends User> T convertToSpecificUser(User user, T t){
        t.setEmail(user.getEmail());
        t.setId(user.getId());
        t.setName(user.getName());
        t.setUsername(user.getUsername());
        t.setIsAdmin(user.getIsAdmin());
        t.setPassword(user.getPassword());
        t.setUserType(user.getUserType());
        t.setAddress(user.getAddress());
        t.setAllergies(user.getAllergies());
        t.setLicence(user.getLicence());
        t.setPatientEmergencyId(user.getPatientEmergencyId());
        t.setPrescriptions(user.getPrescriptions());
        return t;
    }

    public OtherMedicalStaffDTO translateToOtherMedicalStaffDTO(OtherMedicalStaff otherMedicalStaff){
        OtherMedicalStaffDTO otherMedicalStaffDTO = new OtherMedicalStaffDTO();
        otherMedicalStaffDTO.setPrescriptions(otherMedicalStaff.getPrescriptions());
        otherMedicalStaffDTO.setEmail(otherMedicalStaff.getEmail());
        otherMedicalStaffDTO.setId(otherMedicalStaff.getId());
        otherMedicalStaffDTO.setIsAdmin(otherMedicalStaff.getIsAdmin());
        otherMedicalStaffDTO.setName(otherMedicalStaff.getName());
        otherMedicalStaffDTO.setPassword(otherMedicalStaff.getPassword());
        otherMedicalStaffDTO.setUsername(otherMedicalStaff.getUsername());
        otherMedicalStaffDTO.setUserType(UserType.valueOf(otherMedicalStaff.getUserType()));
        return otherMedicalStaffDTO;
    }
}
