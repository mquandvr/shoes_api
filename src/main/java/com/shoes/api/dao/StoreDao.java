package com.shoes.api.dao;

import com.shoes.api.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StoreDao extends JpaRepository<Store, Long> {

    List<Store> findByDeleted(Boolean deleted);

}
