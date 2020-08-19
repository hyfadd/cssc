package com.cssceg.springjpademo.alltest;

import com.cssceg.springjpademo.SpringjpademoApplication;
import com.cssceg.springjpademo.dao.*;
import com.cssceg.springjpademo.domain.Customer;
import com.cssceg.springjpademo.domain.Material;
import com.cssceg.springjpademo.domain.Process;
import com.cssceg.springjpademo.domain.Technology;
import com.cssceg.springjpademo.service.impl.MaterialMethodImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringjpademoApplication.class)
public class CustomerTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private TypeNameDao typeNameDao;
    @Autowired
    private MaterialDao materialDao;
    @Autowired
    private ProcessDao processDao;
    @Autowired
    private TechnologyDao technologyDao;

    @Test
    public void findAll2() {
        List<Material> materialList = materialDao.findAll();
        Integer typt = 1;
        /**
         * 1。获得List<String></>
         */
        Set<String> liucheng = new HashSet<>();
        for (Material material : materialList) {
            Integer material_pr = material.getMaterial_pr();
            if (material_pr != 0) {
                Optional<Process> one = processDao.findById(material_pr);
                String pr_number = one.get().getPr_number();
                liucheng.add(pr_number);
            }
        }
        List<Process> bytype = processDao.findBytype(1);
        for (Process process : bytype) {
            liucheng.add(process.getPr_number());
        }
        List<Technology> technologies=new ArrayList<>();
        Technology one=new Technology();
        for (String s : liucheng) {
            String[] split = s.split(",");
            for (int i = 0; i < split.length; i++) {
                one = technologyDao.getOne(Integer.parseInt(split[i]));
                if (i + 1 < split.length) {
                    one.setNext_node(Integer.parseInt(split[i+1]));
                } else {
                    one.setNext_node(0);
                }
                technologies.add(one);
            }
        }
        HashSet <Technology>technologyHashSet=new HashSet<>(technologies);


    }

    @Test
    public void findAll() {
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(all.toString());
        }
    }

    @Test
    public void ok() {
        MaterialMethodImpl mimpl = new MaterialMethodImpl();
        Material m1 = new Material();
        m1.setMaterial_ts(10.0);
        m1.setRi_shangll(1000.0);

        Material m2 = new Material();
        m2.setMaterial_ts(10.0);
        m2.setRi_shangll(1000.0);
        List<Material> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);

        Double tsRange = mimpl.getTsRange(list);
        System.out.println(tsRange);//6.666666666666667
    }
    /**
     * testExtent
     * testGetOne:要想在单元测试中使用需要添加@Tractionnsat（事物支持），延迟加载，返回的是动态加载对象，到了调用的时候才会加载
     * testFindOne：立即加载
     *
     *
     */
    @Test
    public void rrr(){
        List<Material> list = materialDao.getList();
        for (Material material : list) {
            System.out.println(material);

        }
    }
}
