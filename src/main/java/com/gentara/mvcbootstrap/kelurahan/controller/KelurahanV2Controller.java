package com.gentara.mvcbootstrap.kelurahan.controller;

import com.gentara.mvcbootstrap.kelurahan.model.*;
import com.gentara.mvcbootstrap.kelurahan.service.KelurahanService;
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
@RequestMapping("/kelurahan/v2")
public class KelurahanV2Controller {
    private final KelurahanService kelurahanService;

    public KelurahanV2Controller(KelurahanService kelurahanService) {
        this.kelurahanService = kelurahanService;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("kelurahan/list");
        modelAndView.addObject("kelurahanList", kelurahanService.getAllKelurahan());
        return modelAndView;
    }


    @GetMapping("/kelurahan/detail/{id}")
    private ModelAndView kelurahanDetail(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("kelurahan/detail");
        modelAndView.addObject("id", id);

        Optional<KelurahanModel> kelurahan = kelurahanService.getKelurahanById(id);
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

        Optional<KelurahanModel> kelurahan = kelurahanService.getKelurahanById(id);
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

        Optional<KelurahanModel> kelurahan = kelurahanService.getKelurahanById(id);
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

        Optional<KelurahanModel> kelurahan = kelurahanService.getKelurahanById(id);
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
