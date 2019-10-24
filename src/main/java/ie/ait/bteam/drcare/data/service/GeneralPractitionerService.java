package ie.ait.bteam.drcare.data.service;

import ie.ait.bteam.drcare.data.model.GeneralPractitioner;
import ie.ait.bteam.drcare.data.repository.GeneralPractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneralPractitionerService {

    private GeneralPractitionerRepository generalPractitionerRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public GeneralPractitionerService(GeneralPractitionerRepository generalPractitionerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.generalPractitionerRepository = generalPractitionerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Gets General Practitioner using the ID
     * @param id
     * @return the General Practitioner if found
     */
    public GeneralPractitioner get(Long id){
        return generalPractitionerRepository.findById(id).get();
    }

    /**
     * Fetches all general practitioners
     * @return List<GeneralPractitioner>
     */
    public List<GeneralPractitioner> getAll(){
        //return getMock();

        return generalPractitionerRepository.findAll();
    }

    private List<GeneralPractitioner> getMock(){

        List<GeneralPractitioner> gps = new ArrayList<>();

        GeneralPractitioner gp1 = new GeneralPractitioner();
        gp1.setEmail("mail@seun.com");
        gp1.setName("Seun");
        gp1.setUsername("seun");

        gps.add(gp1);
        return gps;
    }

    /**
     * Create a General Practitioner
     * @param generalPractitioner
     * @return GeneralPractitioner
     */
    public GeneralPractitioner create(GeneralPractitioner generalPractitioner){
        generalPractitioner.setPassword(passwordEncoder.encode(generalPractitioner.getPassword()));
        return  generalPractitionerRepository.save(generalPractitioner);
    }
}
