package com.ejparteuno.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ejparteuno.demo.Model.Country;

@Repository
public interface CountryRepository extends JpaRepository <Country, Long> {
}
