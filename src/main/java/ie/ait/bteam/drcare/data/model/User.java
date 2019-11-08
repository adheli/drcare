package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class User extends Base implements Serializable {


	@Getter
	@Setter
	@Column(unique = true)
	private String patientEmergencyId;

	@Getter
	@Setter
	@Column(unique = true)
	private String licence;
}
