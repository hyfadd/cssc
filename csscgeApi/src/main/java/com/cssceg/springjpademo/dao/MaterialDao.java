package com.cssceg.springjpademo.dao;

import com.cssceg.springjpademo.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface MaterialDao extends JpaRepository<Material,Integer>, JpaSpecificationExecutor<Material> {
    @Query(value = "select material_id,material_name,material_ts from material_properties where material_id != 12 ",nativeQuery = true)
    List<Map<String,Object>> getMaterials();

    @Query(value = "select material_id,material_name,material_ts from material_properties where material_ts > 0.3 ",nativeQuery = true)
    List<Map<String,Object>> getGaoHanGu();

    @Query(value="from Material m where m.material_id <> 12 ")
    public List<Material> getList();
}
