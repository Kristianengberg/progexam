package progexam.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import progexam.demo.AJAX.AJAXstudent;
import progexam.demo.model.Student;
import progexam.demo.model.Supervisor;
import progexam.demo.service.StudentService;
import progexam.demo.service.SupervisorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SupervisorService supervisorService;





    @PostMapping("/api/addStudent")
    public ResponseEntity addStudent(@RequestBody AJAXstudent ajaxStudent){
        System.out.println("addstudent kaldet");
        System.out.println(ajaxStudent.geteMail() + " " + ajaxStudent.getSupervisor() + " " + ajaxStudent.getName());

        Student student = new Student();
        student.seteMail(ajaxStudent.geteMail());
        student.setName(ajaxStudent.getName());
        student.setSupervisor(supervisorService.findbyId(ajaxStudent.getSupervisor()).get());

        studentService.save(student);

        return ResponseEntity.ok("added");
    }


    @GetMapping("/api/showStudents")
    public ResponseEntity displayAllStudents(){

        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping("/api/deleteStudent")
    public void deleteStudentById(@RequestBody AJAXstudent ajaxStudent){
        studentService.deleteById(ajaxStudent.getId());
    }




    @PostMapping("/api/updateStudent")
    public void updateStudent(@RequestBody AJAXstudent ajaxStudent) {
        System.out.println("hehe");

        Student student = studentService.findbyId(ajaxStudent.getId()).get();

        student.setName(ajaxStudent.getName());
        student.setSupervisor(supervisorService.findbyId(ajaxStudent.getId()).get());
        student.seteMail(ajaxStudent.geteMail());

        studentService.save(student);
    }


}
