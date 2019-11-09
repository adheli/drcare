package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.OtherMedicalStaff;
import ie.ait.bteam.drcare.data.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 05-Nov-2019
 */
@Repository
public interface OtherMedicalStaffRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.userType = ?1")
    List<User> findAllOtherMedicalStaff(String userType);

    @Query("select u from User u where u.username = ?1")
    User findOtherMedcialStaffByUsername(String username);

    @Query("select u from User u where u.email = ?1")
    User findOtherMedcialStaffByEmail(String email);

    @Query("select u from User u where u.id = ?1 and u.userType = ?2")
    Optional<User> findOtherMedcialStaffById(Long id, String userType);
}
