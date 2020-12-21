package progexam.demo.service.springdatajpa;

import org.springframework.stereotype.Service;
import progexam.demo.model.Student;
import progexam.demo.repositories.StudentRepository;
import progexam.demo.service.StudentService;

import java.util.*;

@Service
public class StudentJPA implements StudentService {
    private final StudentRepository studentRepository;

    public StudentJPA(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        studentRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);

    }

    @Override
    public Optional<Student> findbyId(Long aLong) {
        return studentRepository.findById(aLong);
    }
}
