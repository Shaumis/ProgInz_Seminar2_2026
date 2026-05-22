package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.enumarator.Degree;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterStuff;

@Service
public class FilterStuffImpl implements IFilterStuff {
	@Autowired
	private IStudentRepo studRepo;
	@Autowired
	private IGradeRepo gradRepo;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfGrad(Degree degree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
