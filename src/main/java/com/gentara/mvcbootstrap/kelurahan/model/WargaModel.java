package com.gentara.mvcbootstrap.kelurahan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WargaModel {
    private String id;
    private String namaWarga;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
    private List<SekolahModel> pendidikan = new ArrayList<>();

    public WargaModel(String id, String namaWarga, String tempatLahir, LocalDate tanggalLahir, String jenisKelamin) {
        this.id = id;
        this.namaWarga = namaWarga;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }
}
