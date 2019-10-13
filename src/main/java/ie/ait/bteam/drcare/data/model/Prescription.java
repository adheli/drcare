package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Prescription implements Serializable {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column
	@NotNull
	private String referenceId;

	@Getter
	@Setter
	@Column
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdDate;

	@Getter
	@Setter
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Medicine> medicines;

	@Getter
	@Setter
	@ManyToMany
	@JoinTable(name = "prescription_users", joinColumns = {@JoinColumn(referencedColumnName = "id", name = "patient_id", nullable = false)})
	private User patient;

	@Getter
	@Setter
	@ManyToMany
	@JoinTable(name = "prescription_users", joinColumns = {@JoinColumn(referencedColumnName = "id", name = "doctor_id", nullable = false)})
	private User doctor;

	@Getter
	@Setter
	@ManyToMany
	@JoinTable(name = "prescription_users", joinColumns = {@JoinColumn(referencedColumnName = "id", name = "pharmacist_id", nullable = false)})
	private User pharmacist;

	@Getter
	@Setter
	@Column
	private String notes;

	@Getter
	@Setter
	@Column
	@NotNull
	private String status;

}
