package com.jee.helloworld.controller;

import com.jee.helloworld.model.Student;
import com.jee.helloworld.model.Survey;
import com.jee.helloworld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String listAll(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        //Next line is mandatory for the form to work
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping(path = "/create")
    public String create(@ModelAttribute Student pStudent){
        studentRepository.save(pStudent);

        return "redirect:/";
    }

    @GetMapping("/student/update")
    public String update(Model pModel, @RequestParam("studentId") int studentId){
        Student student = studentRepository.findOne(studentId);
        pModel.addAttribute("student", student);

        return "studentForm";
    }

    @PostMapping(path = "/student/update")
    public String update(@ModelAttribute Student pStudent){
        studentRepository.save(pStudent);

        return "redirect:/";
    }

    @GetMapping(path = "/student/delete")
    public String delete(@RequestParam("studentId") int studentId) {
        studentRepository.delete(studentId);

        return "redirect:/";
    }
}
