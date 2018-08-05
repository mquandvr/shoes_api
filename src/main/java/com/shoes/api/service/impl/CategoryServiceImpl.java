package com.shoes.api.service.impl;

import com.shoes.api.dao.CategoryDao;
import com.shoes.api.dto.CategoryDTO;
import com.shoes.api.mapper.CategoryMapper;
import com.shoes.api.model.Category;
import com.shoes.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> findAll() {
        List<CategoryDTO> list = new ArrayList<>();
        List<Category> categories = categoryDao.findByDeleted(false);
        if (categories != null && !categories.isEmpty()) {
            categories.forEach(item -> {
                list.add(categoryMapper.convertEntity2Dto(item));
            });
        }
        return list;
    }

    @Override
    public void delete(Long id) {
        Category category = categoryDao.getOne(id);
        if (category != null && category.getId() != null) {
            category.setDeleted(false);
            categoryDao.save(category);
        }
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Category user = categoryMapper.convertDto2Entity(dto);
        user = categoryDao.save(user);
        return categoryMapper.convertEntity2Dto(user);
    }

    @Override
    public CategoryDTO findById(Long id) {
        Category category = categoryDao.getOne(id);
        return categoryMapper.convertEntity2Dto(category);
    }
}
