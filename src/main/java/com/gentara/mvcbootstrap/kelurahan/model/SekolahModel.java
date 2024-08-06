package com.gentara.mvcbootstrap.kelurahan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SekolahModel {
    private String id;
    private String namaSekolah;
    private String jenisSekolah;
    private String alamatSekolah;
    private List<KelasModel> daftarKelas = new ArrayList<>();
}
