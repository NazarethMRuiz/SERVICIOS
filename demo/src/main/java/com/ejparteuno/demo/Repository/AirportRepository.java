package com.ejparteuno.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejparteuno.demo.Model.Airport;

@Repository
public interface AirportRepository extends JpaRepository <Airport, Long> {

}
