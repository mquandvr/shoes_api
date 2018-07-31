package com.shoes.api.dto;

import javax.persistence.*;
import java.io.Serializable;

public class StoreDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StoreDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
