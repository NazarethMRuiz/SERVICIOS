package com.ejparteuno.demo.Service;

import com.ejparteuno.demo.Model.Airport;
import java.util.List;

public interface AirportService {
    Airport createAirport(Airport airport);
    Airport updateAirport(Airport airport);
    List<Airport> getAllAirports();
    Airport getAirportById(long airportId);
    void deleteAirport(long id);
}
