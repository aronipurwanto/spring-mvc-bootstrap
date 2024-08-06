package com.gentara.mvcbootstrap.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolHistoryRes {
    private int id;
    private String schoolName;
    private String schoolAddress;
    private String schoolCity;
    private List<SchoolClassRes> schoolClasses = new ArrayList<SchoolClassRes>();
}
