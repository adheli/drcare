package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.Medicine;
import ie.ait.bteam.drcare.data.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

	private MedicineRepository medicineRepository;

	@Autowired
	public MedicineService(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}

	public Medicine create(Medicine medicine) {
		return medicineRepository.save(medicine);
	}
}
