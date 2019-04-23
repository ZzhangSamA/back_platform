package com.back.rsx.service.imp;

import com.back.rsx.mapper.SupplierMapper;
import com.back.rsx.pojo.Supplier;
import com.back.rsx.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImp implements SupplierService {
    @Autowired(required = false)
    SupplierMapper supplierMapper;
    public List<Supplier> getAllSupplier() {
        return supplierMapper.getAllSupplier();
    }
}
