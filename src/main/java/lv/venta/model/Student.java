package lv.venta.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "StudentTable")
@Entity
public class Student {
	@Column(name="Ids")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long ids;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([a-ž]{2,20}))?")
	@Column(name = "Name")
	private String name;
	@NotEmpty
	@NotNull
	@Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([a-ž]{2,20}))?")
	@Column(name = "Surname")
	private String surname;

	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);

	}

}
