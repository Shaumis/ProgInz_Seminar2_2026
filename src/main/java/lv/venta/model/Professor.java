package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")
@Entity
public class Professor {
	
	@Column(name = "Idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idp;

	@NotEmpty
	@NotNull
	@Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([a-ž]{2,20}))?")
	@Column(name = "Name")
	private String name;

	@NotEmpty
	@NotNull
	@Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ -]{1}([a-ž]{2,20}))?")
	@Column(name = "Surname")
	private String surname;

	@NotEmpty
	@NotNull
	@Column(name = "Degree")
	@Enumerated(EnumType.STRING)
	private lv.venta.model.enumarator.Degree degree;
	
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	private Course course;

	public Professor(String name, String surname, lv.venta.model.enumarator.Degree degree) {
		setName(name);
		setSurname(surname);
		setDegree(degree);

	}

}