package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.model.OtherMedicalStaff;
import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.repository.GeneralPractitionerRepository;
import ie.ait.bteam.drcare.data.repository.OtherMedicalStaffRepository;
import ie.ait.bteam.drcare.rest.dto.OtherMedicalStaffDTO;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.dto.UserType;
import ie.ait.bteam.drcare.rest.service.UserRestService;
import ie.ait.bteam.drcare.rest.translator.Translator;
import ie.ait.bteam.drcare.rest.translator.impl.UserToOtherMedicalStaffTranslator;
import ie.ait.bteam.drcare.util.ModelConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Pelumi.Oyefeso on 05-Nov-2019
 */
@Service
public class OtherMedicalStaffService {

    private OtherMedicalStaffRepository otherMedicalStaffRepository;
    private Translator<User, UserDTO> userTranslator;
    private UserService userService;
    private ModelConversionUtil modelConversionUtil;
    private UserToOtherMedicalStaffTranslator userToOtherMedicalStaffTranslator;

    @Autowired
    public OtherMedicalStaffService(OtherMedicalStaffRepository otherMedicalStaffRepository, UserService userService,
                                    ModelConversionUtil modelConversionUtil,
                                    UserToOtherMedicalStaffTranslator userToOtherMedicalStaffTranslator,
                                    @Qualifier("userToUserDTOTranslator") Translator<User, UserDTO> userTranslator) {
        this.otherMedicalStaffRepository = otherMedicalStaffRepository;
        this.userTranslator = userTranslator;
        this.userToOtherMedicalStaffTranslator = userToOtherMedicalStaffTranslator;
        this.userService = userService;
        this.modelConversionUtil = modelConversionUtil;
    }

    /**
     * Gets other medical staff using the ID
     * @param id id to search with
     * @return the other medical staff if found
     */
    public OtherMedicalStaffDTO get(Long id) {
        Optional<User> foundUser = otherMedicalStaffRepository.findOtherMedcialStaffById(id, UserType.OTHER.toString());
        if (foundUser.isPresent()) {
            OtherMedicalStaff otherMedicalStaff = userToOtherMedicalStaffTranslator.translateFrom(foundUser.get());
            return modelConversionUtil.translateToOtherMedicalStaffDTO(otherMedicalStaff);
        }
        return null;
    }

    /**
     * Gets other medical staff using the ID
     * @param username username to search with
     * @return the other medical staff if found
     */
    public List<OtherMedicalStaffDTO> get(String username) {
        List<User> foundUsers = userService.findUserByUsernameAndType(username, UserType.OTHER.toString());
        if(foundUsers == null){
            return null;
        }
        else{
            List<OtherMedicalStaffDTO> otherMedicalStaffDTOs = foundUsers.stream()
            .map(foundUser -> {
                return modelConversionUtil.translateToOtherMedicalStaffDTO(userToOtherMedicalStaffTranslator.translateFrom(foundUser));
            })
            .collect(Collectors.toList());
            return otherMedicalStaffDTOs;
        }

    }

    /**
     * Fetches all other medical staff
     *
     * @return List<OtherMedicalStaffDTO>
     */
    public List<OtherMedicalStaffDTO> getAll() {
        return otherMedicalStaffRepository.findAllOtherMedicalStaff(UserType.OTHER.toString()).stream()
                .map(user -> {
                    return userToOtherMedicalStaffTranslator.translateFrom(user);
                })
                .map(otherMedicalStaff -> {
                    return modelConversionUtil.translateToOtherMedicalStaffDTO(otherMedicalStaff);
                })
                .collect(Collectors.toList());
                //.filter(otherMedicalStaff -> {return MedicalStaffType.OTHER.toString().equals(otherMedicalStaff.getUserType());})
    }

    /**
     * Create other medical staff
     * @param userDTO
     * @param result
     * @return other medical staff
     */
    public OtherMedicalStaffDTO create(UserDTO userDTO, BindingResult result){
        User createdUser = userTranslator.translateTo(userDTO);
        createdUser = userService.createUser(createdUser, result);
        OtherMedicalStaff otherMedicalStaff = userToOtherMedicalStaffTranslator.translateFrom(createdUser);
        return  modelConversionUtil.translateToOtherMedicalStaffDTO(otherMedicalStaff);
    }

    /**
     * Update other medical staff
     * @param userDTO
     * @param result
     * @return other medical staff
     */
    /*public OtherMedicalStaffDTO update(UserDTO userDTO, BindingResult result){
        User user = userTranslator.translateTo(userDTO);
        user = otherMedicalStaffRepository.updateUser(user, result);
        OtherMedicalStaff otherMedicalStaff = userToOtherMedicalStaffTranslator.translateFrom(user);
        return  modelConversionUtil.translateToOtherMedicalStaffDTO(otherMedicalStaff);
    }*/
}
