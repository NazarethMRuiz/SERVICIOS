package com.ejparteuno.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ejparteuno.demo.Model.Language;

@Repository
public interface LanguageRepository extends JpaRepository <Language, Long> {

}
