package com.gentara.mvcbootstrap.kelurahan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DusunModel {
    private String id;
    private String name;
    private KelurahanModel kelurahan;
    private List<RWModel> daftarRW = new ArrayList<RWModel>();

    public DusunModel(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
