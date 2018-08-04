package com.shoes.api.mapper.impl;

import com.shoes.api.dto.CategoryDTO;
import com.shoes.api.mapper.CategoryMapper;
import com.shoes.api.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO convertEntity2Dto(Category entity) {
        if (entity == null) return null;
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(entity.getId());
        categoryDTO.setName(entity.getName() != null ? entity.getName() : "");
        categoryDTO.setDescription(entity.getDescription() != null
                ? entity.getDescription() : "");
        categoryDTO.setDeleted(entity.getDeleted() != null ? entity.getDeleted() : false);
        categoryDTO.setStoreId(entity.getStoreId());
        return categoryDTO;
    }

    @Override
    public Category convertDto2Entity(CategoryDTO dto) {
        if (dto == null) return null;
        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setName(dto.getName() != null ? dto.getName() : "");
        entity.setDescription(dto.getDescription() != null ? dto.getDescription() : "");
        entity.setDeleted(dto.getDeleted() != null ? dto.getDeleted() : false);
        entity.setStoreId(dto.getStoreId());
        return entity;
    }

}
