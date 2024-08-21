package com.gentara.mvcbootstrap.kelurahan.service;

import com.gentara.mvcbootstrap.kelurahan.model.KelurahanModel;

import java.util.List;
import java.util.Optional;

public interface KelurahanService {
    List<KelurahanModel> getAllKelurahan();
    Optional<KelurahanModel> getKelurahanById(String id);
    Optional<KelurahanModel> addKelurahan(KelurahanModel kelurahan);
    Optional<KelurahanModel> updateKelurahan(KelurahanModel kelurahan);
    Optional<KelurahanModel> deleteKelurahan(String id);
}
