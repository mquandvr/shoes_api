package com.shoes.api.mapper;

import com.shoes.api.dto.CategoryDTO;
import com.shoes.api.dto.StoreDTO;
import com.shoes.api.model.Category;
import com.shoes.api.model.Store;

public interface StoreMapper {

    StoreDTO convertEntity2Dto(Store entity);

    Store convertDto2Entity(StoreDTO dto);

}
