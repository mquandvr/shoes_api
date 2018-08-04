package com.shoes.api.service;

import com.shoes.api.dto.SupplierDTO;
import java.util.List;

public interface SupplierService {

    SupplierDTO save(SupplierDTO dto);

    List<SupplierDTO> findAll();

    void delete(Long id);
    
}
