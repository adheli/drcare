package ie.ait.bteam.drcare.rest.translator.impl;

import ie.ait.bteam.drcare.data.model.OtherMedicalStaff;
import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.rest.dto.MedicalStaffType;
import ie.ait.bteam.drcare.rest.dto.OtherMedicalStaffDTO;
import ie.ait.bteam.drcare.rest.dto.PatientDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import ie.ait.bteam.drcare.util.ModelConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Pelumi.Oyefeso on 05-Nov-2019
 */
@Component
public class UserToOtherMedicalStaffTranslator {
    @Autowired
    ModelConversionUtil modelConversionUtil;

    public OtherMedicalStaff translateFrom(User original) {
        OtherMedicalStaff otherMedicalStaff = new OtherMedicalStaff();
        return modelConversionUtil.convertToSpecificUser(original, otherMedicalStaff);
    }
}
