package com.shoes.api.controller;

import com.shoes.api.dto.SupplierDTO;
import com.shoes.api.service.SupplierService;
import com.shoes.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public List<SupplierDTO> listCategory() {
        return supplierService.findAll();
    }

    @RequestMapping(value = "/suppliers/supplier", method = RequestMethod.POST)
    public SupplierDTO create(@RequestBody SupplierDTO dto) {
        return supplierService.save(dto);
    }

    @RequestMapping(value = "/suppliers/supplier", method = RequestMethod.PUT)
    public SupplierDTO update(@RequestBody SupplierDTO dto) {
        return supplierService.save(dto);
    }

    @RequestMapping(value = "/suppliers/supplier/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Long id) {
        supplierService.delete(id);
        return Constants.SUCCESS_MSG;
    }

}
