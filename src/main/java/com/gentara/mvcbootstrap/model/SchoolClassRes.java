package com.gentara.mvcbootstrap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClassRes {
    private int id;
    private String className;
    private LocalDate startDate;
    private LocalDate endDate;
    private String teacherName;
}
