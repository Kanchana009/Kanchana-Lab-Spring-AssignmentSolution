package in.greatlearning.StudentFest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greatlearning.StudentFest.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByNameContainsAndCountryContainsAllIgnoreCase(String name, String country);

}
