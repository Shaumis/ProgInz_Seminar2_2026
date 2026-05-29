package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.enumarator.Degree;
import lv.venta.service.IFilterStuff;

@Controller
@RequestMapping("/filter")
public class FilterStudentController {
	@Autowired
	private IFilterStuff filterService;
	
	@GetMapping("grade/student/{id}")
	public String getControllerGradesByStudentID(@PathVariable(name = "id")long id, Model model) {
		try {
			model.addAttribute("package",filterService.filterGradesByStudentID(id));
			return "show-selected-grades";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error-page";
		}
	}
	
	@GetMapping("/grade/course/{title}")
	public String getControllerGradesbyCourseTitle(@PathVariable(name="title")String title, Model model) {
		try {
			model.addAttribute("package",filterService.filterGradesWithinCourse(title));
			return "show-selected-grades";
		} catch (Exception e) {
			return "error-page";
		}
		
	}
	@GetMapping("/course/{degree}")
	public String getControllerCoursesByProfDegrees(@PathVariable(name="degree")Degree degree, Model model) {
		try {
			model.addAttribute("package",filterService.filterCoursesByProfGrad(degree));
			return "show-selected-courses";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error-page";
		}
	}

}
