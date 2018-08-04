package com.shoes.api.service.impl;

import com.shoes.api.dao.StoreDao;
import com.shoes.api.dto.StoreDTO;
import com.shoes.api.mapper.StoreMapper;
import com.shoes.api.model.Store;
import com.shoes.api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private StoreMapper storeMapper;

    public List<StoreDTO> findAll() {
        List<StoreDTO> list = new ArrayList<>();
        List<Store> stores = storeDao.findByDeleted(false);
        if (stores != null && !stores.isEmpty()) {
            stores.forEach(item -> {
                list.add(storeMapper.convertEntity2Dto(item));
            });
        }
        return list;
    }

    @Override
    public void delete(Long id) {
        Store store = storeDao.getOne(id);
        if (store != null && store.getId() != null) {
            store.setDeleted(false);
            storeDao.save(store);
        }
    }

    @Override
    public StoreDTO save(StoreDTO dto) {
        Store store = storeMapper.convertDto2Entity(dto);
        store = storeDao.save(store);
        return storeMapper.convertEntity2Dto(store);
    }
    
}
