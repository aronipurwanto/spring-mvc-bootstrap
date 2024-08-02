package com.gentara.mvcbootstrap.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SchoolHistoryRes {
    private int id;
    private String schoolName;
    private String schoolAddress;
    private String schoolCity;
    private List<SchoolClassRes> schoolClasses = new ArrayList<SchoolClassRes>();
}
