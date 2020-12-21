package progexam.demo.service.springdatajpa;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.stereotype.Service;
import progexam.demo.model.Supervisor;
import progexam.demo.repositories.SupervisorRepository;
import progexam.demo.service.SupervisorService;

import java.util.*;

@Service
public class SupervisorJPA implements SupervisorService {
    private final SupervisorRepository supervisorRepository;

    public SupervisorJPA(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public List<Supervisor> findAll() {
        List<Supervisor> list = new ArrayList<>();
        supervisorRepository.findAll().forEach(list::add);
        return list;
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
