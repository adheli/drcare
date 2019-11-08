package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends BaseRepository<Patient,Long>{


    @Query("select p from Patient p where p.userType = 'PATIENT'")
    List<Patient> findAll();

    //Patient findByEmail();
    List<Patient> findByName();
}
