package com.shoes.api.mapper.impl;

import com.shoes.api.dao.CategoryDao;
import com.shoes.api.dto.SupplierDTO;
import com.shoes.api.mapper.SupplierMapper;
import com.shoes.api.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public SupplierDTO convertEntity2Dto(Supplier entity) {
        if (entity == null) return null;
        SupplierDTO dto = new SupplierDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName() != null ? entity.getName() : "");
        dto.setCategoryId(entity.getCategory() != null
                ? entity.getCategory().getId() : null);
        dto.setDeleted(entity.getDeleted());
        return dto;
    }

    @Override
    public Supplier convertDto2Entity(SupplierDTO dto) {
        if (dto == null) return null;
        Supplier entity = new Supplier();
        entity.setId(dto.getId());
        entity.setName(dto.getName() != null ? dto.getName() : "");
        entity.setCategory(categoryDao.getOne(dto.getCategoryId()));
        entity.setDeleted(dto.getDeleted());
        return entity;
    }

}
