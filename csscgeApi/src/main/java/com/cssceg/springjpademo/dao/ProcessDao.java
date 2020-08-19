package com.cssceg.springjpademo.dao;

import com.cssceg.springjpademo.domain.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProcessDao extends JpaRepository<Process,Integer>, JpaSpecificationExecutor<Process> {
        @Query(value="from Process where pr_type = ?1")
        public List<Process> findBytype(Integer custName);
}
