package com.ejparteuno.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ejparteuno.demo.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

}
