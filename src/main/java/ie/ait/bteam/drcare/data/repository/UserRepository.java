package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.staffType = ?1")
	List<User> findByStaffType(String staffType);

	@Query("select u from User u where u.staffType is null and isAdmin = false")
	List<User> findPatients();

	@Query("select u from User u where u.patientEmergencyId = ?1")
	User findByPatientEmergencyId(String patientEmergencyId);

}
