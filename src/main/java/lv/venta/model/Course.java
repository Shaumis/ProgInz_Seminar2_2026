package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "CourseTable")
@Entity
public class Course {
	@Column(name = "Idc", unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idc;

	@NotEmpty
	@NotNull
	@Pattern(regexp = "[A-Ž]{1}[A-Ža-ž0-9 ]{2,40}")
	@Column(name = "Title", unique = true)
	private String title;
	
	@Min(1)
	@Max(40)
	@Column(name = "CP")
	private int credit;
	
	@OneToOne
	@JoinColumn(name = "Idp")
	private Professor professor;

	public Course(String title, int credit, Professor professor) {
		setTitle(title);
		setCredit(credit);
		setProfessor(professor);

	}

}