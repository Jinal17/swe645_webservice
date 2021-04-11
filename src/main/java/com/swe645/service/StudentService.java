package com.swe645.service;

import com.swe645.entity.Student;
import com.swe645.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return repository.saveAll(students);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student getStudentByName(String name) {
        return repository.findByName(name);
    }

    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student removed !! " + id;
    }

    public Student updateStudent(Student student) {
        Student existingProduct = repository.findById(student.getId()).orElse(null);
        existingProduct.setName(student.getName());
        existingProduct.setLastname(student.getLastname());
        existingProduct.setAddress(student.getAddress());
        existingProduct.setCity(student.getCity());
        existingProduct.setState(student.getState());
        existingProduct.setZip(student.getZip());
        existingProduct.setPhone(student.getPhone());
        existingProduct.setEmail(student.getEmail());
        existingProduct.setDos(student.getDos());
        existingProduct.setAbout_college(student.getAbout_college());
        existingProduct.setInterested(student.getInterested());
        existingProduct.setRecommend(student.getRecommend());
        return repository.save(existingProduct);
    }


}
