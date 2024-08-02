package com.gentara.mvcbootstrap.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SchoolClassRes {
    private int id;
    private String schoolClass;
    private LocalDate startDate;
    private LocalDate endDate;
    private String teacherName;
}
