package com.dzcode.springboot.masterclass.springdata;

import com.dzcode.springboot.masterclass.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeSpringDataRepository extends JpaRepository<Employe, Integer> {
}
