package com.shoes.api.service;

import com.shoes.api.dto.StoreDTO;
import java.util.List;

public interface StoreService {

    StoreDTO save(StoreDTO dto);

    List<StoreDTO> findAll();

    void delete(Long id);
    
}
