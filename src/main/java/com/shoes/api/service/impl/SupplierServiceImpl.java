package com.shoes.api.service.impl;

import com.shoes.api.dao.SupplierDao;
import com.shoes.api.dto.SupplierDTO;
import com.shoes.api.mapper.SupplierMapper;
import com.shoes.api.model.Supplier;
import com.shoes.api.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Autowired
    private SupplierMapper supplierMapper;

    public List<SupplierDTO> findAll() {
        List<SupplierDTO> list = new ArrayList<>();
        List<Supplier> suppliers = supplierDao.findByDeleted(false);
        if (suppliers != null && !suppliers.isEmpty()) {
            suppliers.forEach(item -> {
                list.add(supplierMapper.convertEntity2Dto(item));
            });
        }
        return list;
    }

    @Override
    public void delete(Long id) {
        Supplier supplier = supplierDao.getOne(id);
        if (supplier != null && supplier.getId() != null) {
            supplier.setDeleted(false);
            supplierDao.save(supplier);
        }
    }

    @Override
    public SupplierDTO save(SupplierDTO dto) {
        Supplier supplier = supplierMapper.convertDto2Entity(dto);
        supplier = supplierDao.save(supplier);
        return supplierMapper.convertEntity2Dto(supplier);
    }
    
}
