package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneralPractitionerRepository extends CrudRepository<GeneralPractitioner, Long> {
    List<GeneralPractitioner> findAll();
    GeneralPractitioner findByUsername(String username);
    GeneralPractitioner findByEmail(String email);
    Optional<GeneralPractitioner> findById(Long id);

}
