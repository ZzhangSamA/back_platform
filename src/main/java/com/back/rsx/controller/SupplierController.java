package com.back.rsx.controller;



import com.back.rsx.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @RequestMapping(value = "getAllSupplier")
    public Object getAllSupplier(){
        return supplierService.getAllSupplier();
    }
}
