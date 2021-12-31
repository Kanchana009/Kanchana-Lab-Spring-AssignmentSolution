package in.greatlearning.StudentFest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.greatlearning.StudentFest.entities.Student;
import in.greatlearning.StudentFest.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.getById(id);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);

	}

	@Override
	public List<Student> searchBy(String name, String country) {
		// TODO Auto-generated method stub
		return studentRepository.findByNameContainsAndCountryContainsAllIgnoreCase(name, country);
	}

}
