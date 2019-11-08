package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@MappedSuperclass
public class Base {

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
	private String email;

	@Getter
	@Setter
	@Column
	@NotNull
	private Boolean isAdmin;

	@Getter
	@Setter
	@Column
	private String userType;

	@Getter
	@Setter
	@OneToOne(orphanRemoval = true)
	private Address address;


}
