package com.gentara.mvcbootstrap.kelurahan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelurahanModel {
    private String id;
    private String nama;
    private String alamat;
    private String kecamatan;
    private List<DusunModel> daftarDusun = new ArrayList<>();

    public KelurahanModel(String id, String nama, String alamat, String kecamatan) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.kecamatan = kecamatan;
    }
}
