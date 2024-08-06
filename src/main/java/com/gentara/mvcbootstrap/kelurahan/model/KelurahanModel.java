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
    private List<DusunModel> daftarDusun = new ArrayList<>();
    private List<RWModel> daftarRW = new ArrayList<>();
}
