package ie.ait.bteam.drcare.data.repository;

import ie.ait.bteam.drcare.data.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
