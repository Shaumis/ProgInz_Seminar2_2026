package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Professor;
import lv.venta.model.enumarator.Degree;

public interface IProfessorRepo extends CrudRepository<Professor, Long>{

	boolean existsByDegree(Degree degree);

}
