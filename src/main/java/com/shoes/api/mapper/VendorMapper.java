package com.shoes.api.mapper;

import com.shoes.api.dto.CategoryDTO;
import com.shoes.api.dto.VendorDTO;
import com.shoes.api.model.Category;
import com.shoes.api.model.Vendor;

public interface VendorMapper {

    VendorDTO convertEntity2Dto(Vendor entity);

    Vendor convertDto2Entity(VendorDTO dto);

}
