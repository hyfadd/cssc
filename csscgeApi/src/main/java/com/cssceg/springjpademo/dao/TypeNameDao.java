package com.cssceg.springjpademo.dao;

import com.cssceg.springjpademo.domain.TypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeNameDao extends JpaRepository<TypeName,Integer>, JpaSpecificationExecutor<TypeName> {
}
