package com.gentara.mvcbootstrap.kelurahan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RWModel {
    private String id;
    private String name;
    private List<RTModel> daftarRT = new ArrayList<RTModel>();
}
