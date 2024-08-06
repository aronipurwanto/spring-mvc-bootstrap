package com.gentara.mvcbootstrap.controller;

import com.gentara.mvcbootstrap.model.SchoolClassRes;
import com.gentara.mvcbootstrap.model.SchoolHistoryRes;
import com.gentara.mvcbootstrap.model.StudentRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final List<StudentRes> studentResList;

    // constructor
    public StudentController(List<StudentRes> studentResList) {
        this.studentResList = new ArrayList<>();
        List<SchoolHistoryRes> roniSchoolHistoryResList = new ArrayList<>();
        roniSchoolHistoryResList.add(
                new SchoolHistoryRes(11,"SDN 1 Kecubung Raya","Kecubung Raya", "Menggala",
                        Arrays.asList(
                                new SchoolClassRes(111,"Kelas 1", LocalDate.of(1991,7,16), LocalDate.of(1992,6,30),"Ibu Anu"),
                                new SchoolClassRes(112,"Kelas 2", LocalDate.of(1992,7,16), LocalDate.of(1993,6,30),"Ibu Anu"),
                                new SchoolClassRes(113,"Kelas 3", LocalDate.of(1993,7,16), LocalDate.of(1994,6,30),"Ibu Anu"),
                                new SchoolClassRes(114,"Kelas 4", LocalDate.of(1994,7,16), LocalDate.of(1995,6,30),"Ibu Anu"),
                                new SchoolClassRes(115,"Kelas 5", LocalDate.of(1996,7,16), LocalDate.of(1997,6,30),"Ibu Anu"),
                                new SchoolClassRes(116,"Kelas 6", LocalDate.of(1997,7,16), LocalDate.of(1998,6,30),"Ibu Anu")
                        )
                )
        );

        roniSchoolHistoryResList.add(
                new SchoolHistoryRes(12,"SMP 1 Patian Rowo","Patianrowo", "Nganjuk",
                        Arrays.asList(
                                new SchoolClassRes(121,"Kelas 1", LocalDate.of(1998,7,16), LocalDate.of(1999,6,30),"Ibu Anu"),
                                new SchoolClassRes(122,"Kelas 2", LocalDate.of(1999,7,16), LocalDate.of(2000,6,30),"Ibu Anu"),
                                new SchoolClassRes(133,"Kelas 3", LocalDate.of(2000,7,16), LocalDate.of(2001,6,30),"Ibu Anu")
                        )
                )
        );

        roniSchoolHistoryResList.add(
                new SchoolHistoryRes(13,"SMA N 1 Kertosono","Kertosono", "Nganjuk",
                        Arrays.asList(
                                new SchoolClassRes(131,"Kelas 1", LocalDate.of(2001,7,16), LocalDate.of(2002,6,30),"Ibu Anu"),
                                new SchoolClassRes(132,"Kelas 2", LocalDate.of(2002,7,16), LocalDate.of(2003,6,30),"Ibu Anu"),
                                new SchoolClassRes(133,"Kelas 3", LocalDate.of(2004,7,16), LocalDate.of(2005,6,30),"Ibu Anu")
                        )
                )
        );

        StudentRes roni = new StudentRes(1, "Ahmad", "Roni", "Ciamis");
        roni.setSchoolHistory(roniSchoolHistoryResList);

        // generate data
        this.studentResList.add(roni);
        this.studentResList.add(new StudentRes(2,"Ahmad","Sobirin","Ciamis"));
        this.studentResList.add(new StudentRes(3,"Ahmad","Sabilla","Ciamis"));
        this.studentResList.add(new StudentRes(4,"Ahmad","Arifin","Ciamis"));
        this.studentResList.add(new StudentRes(5,"Ahmad","Dhani","Ciamis"));

    }

    @GetMapping
    public ModelAndView getStudent() {
        ModelAndView modelAndView = new ModelAndView("student/list");
        // send data to view
        modelAndView.addObject("studentResList", studentResList);

        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getStudentDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("student/details");

        // get data student
        // cara 1
        //studentResList.stream().filter(x -> x.getId() == id).findFirst().ifPresent(x -> modelAndView.addObject("student", x));

         // cara 2
        Optional<StudentRes> detail = studentResList.stream().filter(x -> x.getId() == id).findFirst();
        if (detail.isPresent()) {
            modelAndView.addObject("student", detail.get());
        } else {
            return new ModelAndView("redirect:/student");
        }

        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newStudents() {
        ModelAndView modelAndView = new ModelAndView("student/new");
        StudentRes studentRes = new StudentRes();

        List<SchoolHistoryRes> schoolHistoryResList = new ArrayList<>();

        // SD Class
        ArrayList<SchoolClassRes> sdClass = new ArrayList<>();
        sdClass.add(new SchoolClassRes(0,"Kelas 1", null, null,""));
        sdClass.add(new SchoolClassRes(0,"Kelas 2", null, null,""));
        sdClass.add(new SchoolClassRes(0,"Kelas 3", null, null,""));
        sdClass.add(new SchoolClassRes(0,"Kelas 4", null, null,""));
        sdClass.add(new SchoolClassRes(0,"Kelas 5", null, null,""));
        sdClass.add(new SchoolClassRes(0,"Kelas 6", null, null,""));

        // SD
        SchoolHistoryRes sdHistory = new SchoolHistoryRes(0,"SD","","",sdClass);
        // add school histoty
        schoolHistoryResList.add(sdHistory);

        // smp class
        ArrayList<SchoolClassRes> smpClass = new ArrayList<>();
        smpClass.add(new SchoolClassRes(0,"Kelas 1", null, null,""));
        smpClass.add(new SchoolClassRes(0,"Kelas 2", null, null,""));
        smpClass.add(new SchoolClassRes(0,"Kelas 3", null, null,""));
        // SMP
        SchoolHistoryRes smpHistory = new SchoolHistoryRes(0,"SMP","","",smpClass);
        // add school history
        schoolHistoryResList.add(smpHistory);

        // sma class
        ArrayList<SchoolClassRes> smaClass = new ArrayList<>();
        smaClass.add(new SchoolClassRes(0,"Kelas 1", null, null,""));
        smaClass.add(new SchoolClassRes(0,"Kelas 2", null, null,""));
        smaClass.add(new SchoolClassRes(0,"Kelas 3", null, null,""));
        // SMP
        SchoolHistoryRes smaHistory = new SchoolHistoryRes(0,"SMA","","",smaClass);
        // add school history
        schoolHistoryResList.add(smaHistory);

        // add to student
        studentRes.setSchoolHistory(schoolHistoryResList);

        modelAndView.addObject("student", studentRes);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveStudent(@ModelAttribute("student") StudentRes studentRes) {
        studentResList.add(studentRes);
        return new ModelAndView("redirect:/student");
    }
}
