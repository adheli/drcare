package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
//public interface UserRepository extends JpaRepository<User, Long> {
//
//	@Query("select u from User u where u.staffType = ?1")
//	List<User> findByStaffType(String staffType);
//
//	@Query("select u from User u where u.staffType is null and isAdmin = false")
//	List<User> findPatients();
//
//	@Query("select u from User u where u.patientEmergencyId = ?1")
//	User findByPatientEmergencyId(String patientEmergencyId);
//
//	@Query("select usr from User usr where usr.username =? 1")
//	User findByUsername(String username);

	List<User> findByStaffType(String staffType);
	List<User> findAll();
	User findByUsername(String username);
	User findByEmail(String email);
}
