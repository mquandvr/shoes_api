package com.shoes.api.dto;

import com.shoes.api.enumeration.Role;
import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;


	private String email;


	private String username;


	private String password;


	private String address;


	private Date birthday;


	private String remarks;

	private Role role;

	private Boolean active;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"id=" + id +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", address='" + address + '\'' +
				", birthday=" + birthday +
				", remarks='" + remarks + '\'' +
				", role=" + role +
				", active=" + active +
				'}';
	}
}
