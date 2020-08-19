package com.cssceg.springjpademo.dao;

import com.cssceg.springjpademo.domain.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TechnologyDao  extends JpaRepository<Technology,Integer>, JpaSpecificationExecutor<Technology> {

}
