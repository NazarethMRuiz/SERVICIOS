package com.ejparteuno.demo.Service;

import com.ejparteuno.demo.exception.ResourceNotFoundException;
import com.ejparteuno.demo.Model.Language;
import com.ejparteuno.demo.Repository.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language updateLanguage(Language language) {
        Optional<Language> languageDb = this.languageRepository.findById(language.getId());

        if (languageDb.isPresent()){
            Language languageUpdate = languageDb.get();
            languageUpdate.setId(language.getId());
            languageUpdate.setName(language.getName());
            languageUpdate.setCode(language.getCode());
            languageRepository.save(languageUpdate);
            return languageUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + language.getId());
        }
    }

    @Override
    public List<Language> getAllLanguage() {
        return this.languageRepository.findAll();
    }

    @Override
    public List<Language> getAllLanguages() {
        return this.languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(long languageId) {
        Optional<Language> languageDb = this.languageRepository.findById(languageId);

        if (languageDb.isPresent()) {
            return languageDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + languageId);
        }
    }

    @Override
    public void deleteLanguage(long languageId) {
        Optional<Language> languageDb = this.languageRepository.findById(languageId);

        if (languageDb.isPresent()) {
            this.languageRepository.delete(languageDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + languageId);
        }
    }

}
