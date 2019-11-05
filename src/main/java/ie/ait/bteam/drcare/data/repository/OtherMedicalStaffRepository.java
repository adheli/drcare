package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.OtherMedicalStaff;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 05-Nov-2019
 */
public interface OtherMedicalStaffRepository extends CrudRepository<OtherMedicalStaff, Long> {
    List<OtherMedicalStaff> findAll();

    OtherMedicalStaff findByUsername(String username);

    OtherMedicalStaff findByEmail(String email);

    Optional<OtherMedicalStaff> findById(Long id);
}
