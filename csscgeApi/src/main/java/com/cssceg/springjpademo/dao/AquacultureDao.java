package com.cssceg.springjpademo.dao;
import com.cssceg.springjpademo.domain.Aquaculture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface AquacultureDao extends JpaRepository<Aquaculture,Integer> ,JpaSpecificationExecutor<Aquaculture>  {
}
