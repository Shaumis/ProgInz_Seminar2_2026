package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.enumarator.Degree;

public interface IFilterStuff {
	
	public abstract ArrayList<Grade> filterGradesByStudentID(long id)throws Exception;
	
	public abstract ArrayList<Grade> filterGradesWithinCourse(String title)throws Exception;
	
	public abstract ArrayList<Course> filterCoursesByProfGrad(Degree degree)throws Exception;

}
