package in.greatlearning.StudentFest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.greatlearning.StudentFest.entities.Student;

@Service
public interface StudentService {
	public List<Student> findAll();

	Student findById(int id);

	void save(Student student);

	void deleteById(int id);

	List<Student> searchBy(String name, String country);

}
