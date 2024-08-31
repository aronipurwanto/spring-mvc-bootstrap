package com.gentara.mvcbootstrap.kelurahan.controller;

import com.gentara.mvcbootstrap.kelurahan.model.KelurahanModel;
import com.gentara.mvcbootstrap.kelurahan.service.KelurahanService;
import com.gentara.mvcbootstrap.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/kelurahan")
public class ApiKelurahanController {
    private final KelurahanService kelurahanService;

    @Autowired
    public ApiKelurahanController(KelurahanService kelurahanService) {
        this.kelurahanService = kelurahanService;
    }

    @GetMapping
    public ResponseEntity<Response> getKelurahan() {
        return ResponseEntity.ok(
                Response.builder()
                        .code(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .message("Success")
                        .data(kelurahanService.getAllKelurahan())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getKelurahan(@PathVariable("id") String id) {

        Optional<KelurahanModel> result = kelurahanService.getKelurahanById(id);
        return result.map(kelurahanModel -> ResponseEntity.ok(
                Response.builder()
                        .code(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .message("Success")
                        .data(kelurahanModel)
                        .build()
        )).orElseGet(() -> ResponseEntity.badRequest().body(
                Response.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST.name())
                        .message("Data not found")
                        .data(null)
                        .build()
        ));
    }

    @PostMapping
    public ResponseEntity<Response> postKelurahan(@RequestBody KelurahanModel request) {
        Optional<KelurahanModel> result = kelurahanService.addKelurahan(request);
        return result.map(kelurahanModel -> ResponseEntity.ok(
                Response.builder()
                        .code(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .message("Success")
                        .data(kelurahanModel)
                        .build()
        )).orElseGet(() -> ResponseEntity.badRequest().body(
                Response.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST.name())
                        .message("Bad Request")
                        .data(null)
                        .build()
        ));
    }
}
