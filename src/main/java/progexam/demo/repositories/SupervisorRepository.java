package progexam.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import progexam.demo.model.Supervisor;

public interface SupervisorRepository extends CrudRepository<Supervisor, Long> {
}
