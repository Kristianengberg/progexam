package progexam.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import progexam.demo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
