package in.greatlearning.StudentFest.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import in.greatlearning.StudentFest.entities.Student;
import in.greatlearning.StudentFest.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentService.findAll();

		model.addAttribute("Students", students);

		return "list-Fests";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// get the Student from the service

		Student student = new Student();
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", student);

		// send over to our form
		return "Fest-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get the Student from the service
		Student theStudent = studentService.findById(theId);

		// set as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "Fest-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);
		Integer studentId = 0;
		try {
			if (id != null)
				studentId = Integer.parseInt(id);
		} catch (Exception e) {

		}
		Student theStudent;
		if (studentId != 0) {
			theStudent = studentService.findById(studentId);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(name, department, country);
		// save the Student
		studentService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Student
		studentService.deleteById(theId);

		// redirect to /Students/list
		return "redirect:/students/list";

	}

	@RequestMapping("/search")
	public String search(@RequestParam("name") String name, @RequestParam("country") String country, Model theModel) {

		// check names, if both are empty then just give list of all students

		if (name.trim().isEmpty() && country.trim().isEmpty()) {
			return "redirect:/students/list";
		} else {
			// else, search by name and author
			List<Student> theStudents = studentService.searchBy(name, country);

			// add to the spring model
			theModel.addAttribute("Students", theStudents);

			// send to list-Students
			return "list-Fests";
		}

	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi" + user.getName() + "you do not have permission to access this page!");
		} else {
			model.addObject("msg", "you do not have permission to access this page!");

		}
		model.setViewName("403");
		return model;

	}

}
