package com.shoes.api.mapper;

import com.shoes.api.dto.SupplierDTO;
import com.shoes.api.model.Supplier;

public interface SupplierMapper {

    SupplierDTO convertEntity2Dto(Supplier entity);

    Supplier convertDto2Entity(SupplierDTO dto);

}
