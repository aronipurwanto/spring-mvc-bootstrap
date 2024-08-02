package com.gentara.mvcbootstrap.controller;

import com.gentara.mvcbootstrap.model.StudentRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final List<StudentRes> studentResList;

    // constructor
    public StudentController(List<StudentRes> studentResList) {
        this.studentResList = new ArrayList<>();
        // generate data
        this.studentResList.add(new StudentRes(1,"Ahmad","Roni","Ciamis"));
        this.studentResList.add(new StudentRes(2,"Ahmad","Sobirin","Ciamis"));
        this.studentResList.add(new StudentRes(3,"Ahmad","Sabilla","Ciamis"));
        this.studentResList.add(new StudentRes(4,"Ahmad","Arifin","Ciamis"));
        this.studentResList.add(new StudentRes(5,"Ahmad","Dhani","Ciamis"));

    }

    @GetMapping
    public ModelAndView getStudent() {
        ModelAndView modelAndView = new ModelAndView("student");
        // send data to view
        modelAndView.addObject("studentResList", studentResList);

        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getStudentDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("studentDetails");

        // get data student
        // cara 1
        //studentResList.stream().filter(x -> x.getId() == id).findFirst().ifPresent(x -> modelAndView.addObject("student", x));

         // cara 2
        Optional<StudentRes> detail = studentResList.stream().filter(x -> x.getId() == id).findFirst();
        if (detail.isPresent()) {
            modelAndView.addObject("studentRes", detail.get());
        } else {
            return new ModelAndView("redirect:/student");
        }

        return modelAndView;
    }
}
