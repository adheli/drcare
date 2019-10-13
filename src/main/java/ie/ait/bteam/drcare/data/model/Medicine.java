package ie.ait.bteam.drcare.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Medicine implements Serializable {

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
	private String name;

	@Getter
	@Setter
	@Column
	@NotNull
	private String typeDosage;

	@Getter
	@Setter
	@Column
	@NotNull
	private Integer dosage;
}
