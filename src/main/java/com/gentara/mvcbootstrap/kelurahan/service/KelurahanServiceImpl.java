package com.gentara.mvcbootstrap.kelurahan.service;

import com.gentara.mvcbootstrap.kelurahan.model.KelurahanModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KelurahanServiceImpl implements KelurahanService {
    private static List<KelurahanModel> kelurahanModels;

    public KelurahanServiceImpl() {
        kelurahanModels = new ArrayList<KelurahanModel>();
    }

    @Override
    public List<KelurahanModel> getAllKelurahan() {
        return kelurahanModels;
    }

    @Override
    public Optional<KelurahanModel> getKelurahanById(String id) {
        KelurahanModel result = kelurahanModels.stream().filter(kelurahanModel -> kelurahanModel.getId().equals(id))
                .findFirst().orElse(null);
        if (kelurahanModels.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(result);
    }

    @Override
    public Optional<KelurahanModel> addKelurahan(KelurahanModel kelurahan) {
        if(kelurahan == null) {
            return Optional.empty();
        }
        kelurahanModels.add(kelurahan);
        return Optional.of(kelurahan);
    }

    @Override
    public Optional<KelurahanModel> updateKelurahan(KelurahanModel kelurahan) {
        int index = 0;
        KelurahanModel result = null;
        for (int i = 0; i < kelurahanModels.size(); i++) {
            if(kelurahanModels.get(i).getId().equals(kelurahan.getId())) {
                result = kelurahanModels.get(i);
                index = i;
            }
        }

        if (result == null) {
            return Optional.empty();
        }
        kelurahanModels.set(index, kelurahan);
        return Optional.of(kelurahan);
    }

    @Override
    public Optional<KelurahanModel> deleteKelurahan(String id) {
        int index = 0;
        KelurahanModel result = null;
        for (int i = 0; i < kelurahanModels.size(); i++) {
            if(kelurahanModels.get(i).getId().equals(id)) {
                result = kelurahanModels.get(i);
                index = i;
            }
        }

        if (result == null) {
            return Optional.empty();
        }
        kelurahanModels.remove(index);
        return Optional.of(result);
    }
}
