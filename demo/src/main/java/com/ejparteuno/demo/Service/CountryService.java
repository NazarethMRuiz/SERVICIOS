package com.ejparteuno.demo.Service;

import com.ejparteuno.demo.Model.Country;
import java.util.List;

public interface CountryService {
    Country createCountry(Country country);
    Country updateCountry(Country country);
    List<Country> getAllCountry();
    Country getCountryById(long countryId);
    void deleteCountry(long id);
}
