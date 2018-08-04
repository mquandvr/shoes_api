package com.shoes.api.mapper.impl;

import com.shoes.api.dto.StoreDTO;
import com.shoes.api.mapper.StoreMapper;
import com.shoes.api.model.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapperImpl implements StoreMapper {

    @Override
    public StoreDTO convertEntity2Dto(Store entity) {
        if (entity == null) return null;
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(entity.getId());
        storeDTO.setName(entity.getName());
        storeDTO.setAddress(entity.getAddress());
        storeDTO.setDeleted(entity.getDeleted());
        return storeDTO;
    }

    @Override
    public Store convertDto2Entity(StoreDTO dto) {
        if (dto == null) return null;
        Store entity = new Store();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }

}
