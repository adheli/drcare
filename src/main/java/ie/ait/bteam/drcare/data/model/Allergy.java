package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Allergy implements Serializable {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column
	@NotNull
	private String mainSubstance;

	@Getter
	@Setter
	@Column
	@NotNull
	private String description;
}
