package com.shoes.api.dao;

import com.shoes.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

    List<Category> findByDeleted(Boolean deleted);

}
