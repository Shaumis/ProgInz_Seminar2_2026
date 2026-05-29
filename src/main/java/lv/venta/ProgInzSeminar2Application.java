package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enumarator.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class ProgInzSeminar2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar2Application.class, args);
	}
	@Bean
	public CommandLineRunner saveDataInDB(IStudentRepo studRepo, IProfessorRepo profRepo, IGradeRepo gradRepo, ICourseRepo courRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor p1 = new Professor("Karina", "Šķirmante", Degree.Master);
				Professor p2 = new Professor("Karlis", "Immers", Degree.Master);
				profRepo.saveAll(Arrays.asList(p1,p2));
				Student s1 = new Student("Mikus", "Ābele");
				Student s2 = new Student("Ivo", "Vilnis");
				studRepo.saveAll(Arrays.asList(s1,s2));
				Course c1 = new Course("Programēšana JAVA", 4, p1);
				Course c2 = new Course("Web tehnoloģijas", 3, p2);
				courRepo.saveAll(Arrays.asList(c1,c2));
				Grade g1 = new Grade(10, s1, c1);
				Grade g2 = new Grade(9, s2, c1);
				gradRepo.saveAll(Arrays.asList(g1,g2));
			}
		};
	}
	
}

