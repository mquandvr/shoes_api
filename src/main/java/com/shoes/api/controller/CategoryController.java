package com.shoes.api.controller;

import com.shoes.api.dto.CategoryDTO;
import com.shoes.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<CategoryDTO> listCategory() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/categories/category", method = RequestMethod.POST)
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return categoryService.save(dto);
    }

    @RequestMapping(value = "/categories/category/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id) {
        categoryService.delete(id);
        return "success";
    }

}
