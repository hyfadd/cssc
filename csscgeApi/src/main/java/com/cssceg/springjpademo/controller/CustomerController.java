package com.cssceg.springjpademo.controller;

import com.cssceg.springjpademo.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

}
