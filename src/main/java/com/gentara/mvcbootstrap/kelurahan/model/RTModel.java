package com.gentara.mvcbootstrap.kelurahan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RTModel {
    private String id;
    private String name;
    private RWModel rw;
    private DusunModel dusun;
    private KelurahanModel kelurahan;
    private List<WargaModel> daftarWarga = new ArrayList<WargaModel>();

    public RTModel(String id, String name, RWModel rw, DusunModel dusun, KelurahanModel kelurahan) {
        this.id = id;
        this.name = name;
        this.rw = rw;
        this.dusun = dusun;
        this.kelurahan = kelurahan;
    }
}
