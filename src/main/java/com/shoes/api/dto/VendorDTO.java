package com.shoes.api.dto;

import com.shoes.api.model.Category;
import java.io.Serializable;

public class VendorDTO implements Serializable {

    private Long id;

    private String name;

    private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "VendorDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", category=" + category +
				'}';
	}
}
