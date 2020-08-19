package com.cssceg.springjpademo.dao;
import com.cssceg.springjpademo.domain.Crafts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CraftsDao extends JpaRepository<Crafts,Integer> ,JpaSpecificationExecutor<Crafts>  {
}
