package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@NotNull
	@Column
	private String name;

	@Getter
	@Setter
	@Column
	private String username;

	@Getter
	@Setter
	@Column
	private String password;

	@Getter
	@Setter
	@Column(unique = true)
	@NotNull
	private String email;

	@Getter
	@Setter
	@Column
	@NotNull
	private Boolean isAdmin = false;

	@Getter
	@Setter
	@Column(unique = true)
	private String licence;

	@Getter
	@Setter
	@Column
	private String staffType;

	@Getter
	@Setter
	@Column(unique = true)
	private String patientEmergencyId;

	@Getter
	@Setter
	@OneToOne(orphanRemoval = true)
	private Address address;

	@Getter
	@Setter
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "user_allergy", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "allergy_id"))
	private List<Allergy> allergies;
}
