package com.gentara.mvcbootstrap.kelurahan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KelasModel {
    private String id;
    private String namaKelas;
    private LocalDate tanggalMasuk;
    private LocalDate tanggalSelesai;
    private String namaGuru;
    private Double nilai;
}
