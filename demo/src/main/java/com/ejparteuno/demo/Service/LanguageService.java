package com.ejparteuno.demo.Service;

import com.ejparteuno.demo.Model.Language;
import java.util.List;

public interface LanguageService {
    Language createLanguage(Language language);
    Language updateLanguage(Language language);
    List<Language> getAllLanguage();

    List<Language> getAllLanguages();

    Language getLanguageById(long languageId);
    void deleteLanguage(long id);

}
