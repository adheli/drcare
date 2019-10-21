package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private String username;

	@Column
	@NotNull
	@Transient
	private transient String password;

	@Column
	@NotNull
	private String email;

	@Column
	@NotNull
	private Boolean isAdmin = false;

	@Column
	private String licence;

	@Column
	private String staffType;

	@Column
	private String patientEmergencyId;

	@OneToOne(orphanRemoval = true)
	private Address address;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "user_allergy", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "allergy_id"))
	private List<Allergy> allergies;
}
