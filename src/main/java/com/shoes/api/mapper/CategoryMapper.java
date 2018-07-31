package com.shoes.api.mapper;

import com.shoes.api.dto.CategoryDTO;
import com.shoes.api.model.Category;

public interface CategoryMapper {

    CategoryDTO convertEntity2Dto(Category entity);

    Category convertDto2Entity(CategoryDTO dto);

}
