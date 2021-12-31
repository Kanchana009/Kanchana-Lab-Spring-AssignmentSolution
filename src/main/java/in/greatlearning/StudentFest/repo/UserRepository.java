package in.greatlearning.StudentFest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.greatlearning.StudentFest.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User getByUsername(String username);

}
