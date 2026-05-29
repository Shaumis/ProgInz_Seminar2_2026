package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;
import lv.venta.model.enumarator.Degree;

public interface IStudentRepo extends CrudRepository<Student, Long>{

	ArrayList<Student> findByGradesAtzLessThan(int i);


}
