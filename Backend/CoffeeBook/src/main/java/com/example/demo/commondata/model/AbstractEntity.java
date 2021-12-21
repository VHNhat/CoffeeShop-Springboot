package com.example.demo.commondata.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@JsonSerialize
public class AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, name = "Id", nullable = false)
	@JsonProperty("Id")
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/*
	 * @Version protected int version;
	 * 
	 * @CreatedBy protected String createdBy;
	 * 
	 * @LastModifiedBy protected String updatedBy;
	 * 
	 * @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	 * 
	 * @CreatedDate
	 * 
	 * @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	 * 
	 * @Column(name = "created_at", nullable = false, updatable = false) protected
	 * LocalDateTime createdAt;
	 * 
	 * @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	 * 
	 * @LastModifiedDate
	 * 
	 * @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	 * 
	 * @Column(name = "updated_at", nullable = false) protected LocalDateTime
	 * updatedAt;
	 */
	
}
