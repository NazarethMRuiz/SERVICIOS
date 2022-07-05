package com.ejparteuno.demo.controller;

import com.ejparteuno.demo.exception.Mensaje;
import com.ejparteuno.demo.Model.Language;
import com.ejparteuno.demo.Service.LanguageService;

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
@RequestMapping("/Languages")
public class LanguageController {
    @Autowired
    private LanguageService LanguageService;

    @GetMapping("/list_Languages")
    public ResponseEntity<?> getAllLanguage(){
        List<Language> lista = LanguageService.getAllLanguages();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin aeropuertos en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(LanguageService.getAllLanguages());
    }

    @GetMapping("/details_Language/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.LanguageService.getLanguageById(id));
    }

    @PostMapping("/create_Language")
    public ResponseEntity<Language> createLanguage(@RequestBody Language Language) {
        return ResponseEntity.ok().body(this.LanguageService.createLanguage(Language));
    }


    @PutMapping("/update_Language/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language Language){
        Language.setId(id);
        return ResponseEntity.ok().body(this.LanguageService.updateLanguage(Language));
    }

    @DeleteMapping("/delete_Language/{id}")
    public HttpStatus deleteLanguage(@PathVariable long id){
        this.LanguageService.deleteLanguage(id);
        return HttpStatus.OK;
    }
}
