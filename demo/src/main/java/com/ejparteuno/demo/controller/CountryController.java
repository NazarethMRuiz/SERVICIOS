package com.ejparteuno.demo.controller;

import com.ejparteuno.demo.exception.Mensaje;
import com.ejparteuno.demo.Model.Country;
import com.ejparteuno.demo.Service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countrys")
public class CountryController {
    @Autowired
    private CountryService CountryService;

    @GetMapping("/list_Countrys")
    public ResponseEntity<?> getAllCountry(){
        List<Country> lista = CountryService.getAllCountry();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin aeropuertos en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(CountryService.getAllCountry());
    }

    @GetMapping("/details_Country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.CountryService.getCountryById(id));
    }

    @PostMapping("/create_Country")
    public ResponseEntity<Country> createCountry(@RequestBody Country Country) {
        return ResponseEntity.ok().body(this.CountryService.createCountry(Country));
    }


    @PutMapping("/update_Country/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country Country){
        Country.setId(id);
        return ResponseEntity.ok().body(this.CountryService.updateCountry(Country));
    }

    @DeleteMapping("/delete_Country/{id}")
    public HttpStatus deleteCountry(@PathVariable long id){
        this.CountryService.deleteCountry(id);
        return HttpStatus.OK;
    }
}
