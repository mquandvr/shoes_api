package com.shoes.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoes.api.enumeration.Role;

import java.util.Date;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;
    
    @Column
    private String address;
    
    @Column
    private Date birthday;

    @Column
    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;
    
    @Column
    private Boolean active;
    
    @CreatedBy
	@Column(name = "created_by", nullable = true, length = 30, updatable = true)
	@JsonIgnore
	private String createdBy;

	@CreatedDate
	@Column(name = "created_date", nullable = true)
	@JsonIgnore
	private Date createdDate = new Date();

	@LastModifiedBy
	@Column(name = "last_modified_by", length = 30)
	@JsonIgnore
	private String lastModifiedBy;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	@JsonIgnore
	private Date lastModifiedDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
