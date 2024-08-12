package com.gentara.mvcbootstrap.kelurahan.controller;

import com.gentara.mvcbootstrap.kelurahan.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/kelurahan")
public class KelurahanController {
    public static List<KelurahanModel> kelurahanList;

    public KelurahanController() {
        this.kelurahanList = new ArrayList<>();

        KelurahanModel sukahurip = new KelurahanModel(UUID.randomUUID().toString(),"SUKAHURIP","Jl. Pamarican","Pamarican");

        DusunModel dusun1 = new DusunModel(UUID.randomUUID().toString(),"DUSUN 01");
        List<RWModel> rwList = new ArrayList<>();
        // rw ditambah ke list
        RWModel rw01 = new RWModel(UUID.randomUUID().toString(),"RW01", dusun1, sukahurip);
        // inisiate object
        List<RTModel> rtList = new ArrayList<>();
        RTModel rt01 = new RTModel(UUID.randomUUID().toString(),"RT01", rw01, dusun1, sukahurip);
        // daftar warga
        List<WargaModel> wargaList = new ArrayList<>();
        WargaModel warga01 = new WargaModel(UUID.randomUUID().toString(),"Warga 01","Ciamis", LocalDate.of(2001,12,1),"PRIA");
        wargaList.add(warga01);

        WargaModel warga02 = new WargaModel(UUID.randomUUID().toString(),"Warga 02","Ciamis", LocalDate.of(2002,11,1),"PRIA");
        wargaList.add(warga02);

        rt01.setDaftarWarga(wargaList);
        rtList.add(rt01);

        RTModel rt02 = new RTModel(UUID.randomUUID().toString(),"RT02", rw01, dusun1, sukahurip);
        rtList.add(rt02);

        RTModel rt03 = new RTModel(UUID.randomUUID().toString(),"RT03", rw01, dusun1, sukahurip);
        rtList.add(rt03);

        // rw01 add daftar RT
        rw01.setDaftarRT(rtList);
        //rw o1 add to daftar RW
        rwList.add(rw01);

        RWModel rw02 = new RWModel(UUID.randomUUID().toString(),"RW02", dusun1, sukahurip);
        rwList.add(rw02);

        RWModel rw03 = new RWModel(UUID.randomUUID().toString(),"RW03", dusun1, sukahurip);
        rwList.add(rw03);

        RWModel rw04 = new RWModel(UUID.randomUUID().toString(),"RW04", dusun1, sukahurip);
        rwList.add(rw04);

        RWModel rw05 = new RWModel(UUID.randomUUID().toString(),"RW05", dusun1, sukahurip);
        rwList.add(rw05);

        // set durun rw
        dusun1.setDaftarRW(rwList);
        dusun1.setKelurahan(sukahurip);

        // daftar dusun
        List<DusunModel> dusunList = new ArrayList<>();
        // add daftar dusun ke object sukahurip
        sukahurip.setDaftarDusun(dusunList);

        // add sukahurip to list
        kelurahanList.add(sukahurip);
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("kelurahan/list");
        modelAndView.addObject("kelurahanList", kelurahanList);
        return modelAndView;
    }


    @GetMapping("/kelurahan/detail/{id}")
    private ModelAndView kelurahanDetail(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("kelurahan/detail");
        modelAndView.addObject("id", id);

        Optional<KelurahanModel> kelurahan = kelurahanList.stream().filter(x -> x.getId().equals(id)).findFirst();
        if(kelurahan.isPresent()){
            modelAndView.addObject("kelurahan", kelurahan.get());
            return modelAndView;
        }else {
            return new ModelAndView("redirect:/kelurahan");
        }
    }

    @GetMapping("/kelurahan/{kelurahanId}/dusun/{dusunId}")
    private ModelAndView dusunDetail(@PathVariable("kelurahanId") String id, @PathVariable("dusunId") String dusunId){
        ModelAndView modelAndView = new ModelAndView("kelurahan/dusun");
        modelAndView.addObject("id", id);

        Optional<KelurahanModel> kelurahan = kelurahanList.stream().filter(x -> x.getId().equals(id)).findFirst();
        if(kelurahan.isPresent()){
            DusunModel dusun = kelurahan.get().getDaftarDusun().stream().filter(x -> x.getId().equals(dusunId)).findFirst().get();
            modelAndView.addObject("dusun", dusun);
            return modelAndView;
        }else {
            return new ModelAndView("redirect:/kelurahan");
        }
    }

    @GetMapping("/kelurahan/{kelurahanId}/dusun/{dusunId}/rw/{rwId}")
    private ModelAndView rwDetail(@PathVariable("kelurahanId") String id,
                                     @PathVariable("dusunId") String dusunId,
                                     @PathVariable("rwId") String rwId){
        ModelAndView modelAndView = new ModelAndView("kelurahan/rw");
        modelAndView.addObject("id", id);

        Optional<KelurahanModel> kelurahan = kelurahanList.stream().filter(x -> x.getId().equals(id)).findFirst();
        if(kelurahan.isPresent()){
            DusunModel dusun = kelurahan.get().getDaftarDusun().stream().filter(x -> x.getId().equals(dusunId)).findFirst().get();
            RWModel rw = dusun.getDaftarRW().stream().filter(x -> x.getId().equals(rwId)).findFirst().get();
            modelAndView.addObject("rw", rw);
            return modelAndView;
        }else {
            return new ModelAndView("redirect:/kelurahan");
        }
    }

    @GetMapping("/kelurahan/{kelurahanId}/dusun/{dusunId}/rw/{rwId}/rt/{rtId}")
    private ModelAndView rtDetail(@PathVariable("kelurahanId") String id,
                                  @PathVariable("dusunId") String dusunId,
                                  @PathVariable("rwId") String rwId,
                                  @PathVariable("rtId") String rtId){
        ModelAndView modelAndView = new ModelAndView("kelurahan/rt");
        modelAndView.addObject("id", id);

        Optional<KelurahanModel> kelurahan = kelurahanList.stream().filter(x -> x.getId().equals(id)).findFirst();
        if(kelurahan.isPresent()){
            DusunModel dusun = kelurahan.get().getDaftarDusun().stream().filter(x -> x.getId().equals(dusunId)).findFirst().get();
            RWModel rw = dusun.getDaftarRW().stream().filter(x -> x.getId().equals(rwId)).findFirst().get();
            RTModel rt = rw.getDaftarRT().stream().filter(x -> x.getId().equals(rtId)).findFirst().get();
            modelAndView.addObject("rt", rt);
            return modelAndView;
        }else {
            return new ModelAndView("redirect:/kelurahan");
        }
    }
}
