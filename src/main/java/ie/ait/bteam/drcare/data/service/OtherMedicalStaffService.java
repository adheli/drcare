package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.model.OtherMedicalStaff;
import ie.ait.bteam.drcare.data.repository.GeneralPractitionerRepository;
import ie.ait.bteam.drcare.data.repository.OtherMedicalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 05-Nov-2019
 */
@Service
public class OtherMedicalStaffService {

    private OtherMedicalStaffRepository otherMedicalStaffRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public OtherMedicalStaffService(OtherMedicalStaffRepository otherMedicalStaffRepository, BCryptPasswordEncoder passwordEncoder) {
        this.otherMedicalStaffRepository = otherMedicalStaffRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Gets other medical staff using the ID
     * @param id id to search with
     * @return the other medical staff if found
     */
    public OtherMedicalStaff get(Long id) {
        Optional<OtherMedicalStaff> foundGP = otherMedicalStaffRepository.findById(id);
        if (foundGP.isPresent()) {
            return foundGP.get();
        }
        return null;
    }

    /**
     * Fetches all other medical staff
     *
     * @return List<OtherMedicalStaff>
     */
    public List<OtherMedicalStaff> getAll() {
        //return getMock();

        return otherMedicalStaffRepository.findAll();
    }

    /**
     * Create other medical staff
     * @param otherMedicalStaff
     * @return other medical staff
     */
    public OtherMedicalStaff create(OtherMedicalStaff otherMedicalStaff){
        otherMedicalStaff.setPassword(passwordEncoder.encode(otherMedicalStaff.getPassword()));
        return  otherMedicalStaffRepository.save(otherMedicalStaff);
    }
}
