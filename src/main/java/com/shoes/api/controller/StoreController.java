package com.shoes.api.controller;

import com.shoes.api.dto.StoreDTO;
import com.shoes.api.service.StoreService;
import com.shoes.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<StoreDTO> listCategory() {
        return storeService.findAll();
    }

    @RequestMapping(value = "/stores/store", method = RequestMethod.POST)
    public StoreDTO create(@RequestBody StoreDTO dto) {
        return storeService.save(dto);
    }

    @RequestMapping(value = "/stores/store", method = RequestMethod.PUT)
    public StoreDTO update(@RequestBody StoreDTO dto) {
        return storeService.save(dto);
    }

    @RequestMapping(value = "/stores/store/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id) {
        storeService.delete(id);
        return Constants.SUCCESS_MSG;
    }

}
