package progexam.demo.service.springdatajpa;

import org.springframework.stereotype.Service;
import progexam.demo.model.Supervisor;
import progexam.demo.repositories.SupervisorRepository;
import progexam.demo.service.SupervisorService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SupervisorJPA implements SupervisorService {
    private final SupervisorRepository supervisorRepository;

    public SupervisorJPA(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public Set<Supervisor> findAll() {
        Set<Supervisor> set = new HashSet<>();
        supervisorRepository.findAll().forEach(set::add); // tilføjer alle elementer til set
        return set;
    }

    @Override
    public Supervisor save(Supervisor object) {
        return supervisorRepository.save(object);
    }

    @Override
    public void delete(Supervisor object) {

        supervisorRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {

        supervisorRepository.deleteById(aLong);

    }

    @Override
    public Optional<Supervisor> findbyId(Long aLong) {
        return supervisorRepository.findById(aLong);
    }
}
