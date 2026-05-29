package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.model.enumarator.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterStuff;

@Service
public class FilterStuffImpl implements IFilterStuff {
	@Autowired
	private IStudentRepo studRepo;
	@Autowired
	private IGradeRepo gradRepo;
	@Autowired
	private ICourseRepo courseRepo;
	@Autowired
	private IProfessorRepo profRepo;

	@Override
	public ArrayList<Grade> filterGradesByStudentID(long id) throws Exception {
		if (id <= 0 || !studRepo.existsById(id) || gradRepo.count() == 0) {
			throw new Exception("ERROR");
		}
		ArrayList<Grade> resultFromDB = gradRepo.findByStudentIds(id);

		if (resultFromDB.isEmpty()) {
			throw new Exception("Nope");
		}
		return resultFromDB;
	}

	@Override
	public ArrayList<Grade> filterGradesWithinCourse(String title) throws Exception {
		if (gradRepo.count() == 0) {
			throw new Exception("Vērtējuma tabula ir tukša");
		}
		if (title == null || title.isEmpty() || !title.matches("[A-Ž]{1}[A-Ža-ž0-9 ]{2,40}")) {
			throw new Exception("Kursa nosaukums neder");

		}
		if (!courseRepo.existsByTitle(title)) {
			throw new Exception("Kurss ar nosaukumu: " + title + " neeksistē");
		}
		ArrayList<Grade> results = gradRepo.findByCourseTitle(title);
		if (results.isEmpty()) {
			throw new Exception("Nav neviena atzīme šim kursam");
		}
		return results;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfGrad(Degree degree) throws Exception {
		if (courseRepo.count() == 0) {
			throw new Exception("Vērtējuma tabula ir tukša");
		}
		if (degree == null) {
			throw new Exception("Profesora grāds neder");
		}
		if (!profRepo.existsByDegree(degree)) {
			throw new Exception("Profesori ar šo grādu nava");
		}
		ArrayList<Course> results = courseRepo.findByProfessorDegree(degree);
		if (results.isEmpty()) {
			throw new Exception("Nav neviens kurss ar professors ar šo grādu");
		}
		return results;
	}

	@Override
	public ArrayList<Student> filterStudentsByGradesUnder4() throws Exception {
		if(gradRepo.count() == 0) {
			throw new Exception("Nav Atzīmju :(");
		}
		if(studRepo.count() == 0) {
			throw new Exception("Nav Studentu :(");
		}//findByGradeAtzLessThan(4);
		ArrayList<Student> results = studRepo.findByGradesAtzLessThan(4);
		return results;
	}

}
