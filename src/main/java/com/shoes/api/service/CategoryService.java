package com.shoes.api.service;

import com.shoes.api.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {

    CategoryDTO save(CategoryDTO dto);

    List<CategoryDTO> findAll();

    void delete(Long id);

    CategoryDTO findById(Long id);
    
}
