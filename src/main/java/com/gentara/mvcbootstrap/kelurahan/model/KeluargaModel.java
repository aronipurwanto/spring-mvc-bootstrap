package com.gentara.mvcbootstrap.kelurahan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeluargaModel {
    private String id;
    private String nomor;
    private String kepalaKeluarga;
    private List<WargaModel> anggota = new ArrayList<>();
}
