package com.shoes.api.dao;

import com.shoes.api.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Long> {

    List<Supplier> findByDeleted(Boolean deleted);

}
