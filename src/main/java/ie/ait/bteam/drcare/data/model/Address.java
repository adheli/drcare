package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Address implements Serializable {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@Column
	@NotNull
	private String street;

	@Getter
	@Setter
	@Column
	private String additionalAddress;

	@Getter
	@Setter
	@Column
	private String eirCode;

	@Getter
	@Setter
	@Column
	@NotNull
	private String town;

	@Getter
	@Setter
	@Column
	private String county;

	@Getter
	@Setter
	@Column
	@NotNull
	private String country;
}
