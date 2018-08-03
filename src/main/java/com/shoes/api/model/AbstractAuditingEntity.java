package com.shoes.api.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return "AbstractAuditingEntity [createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
