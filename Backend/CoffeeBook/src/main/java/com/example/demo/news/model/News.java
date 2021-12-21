package com.example.demo.news.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.commondata.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "News")
@Getter
@Setter
public class News extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(unique = true, name = "Title", nullable = false)
	@JsonProperty("Title")
	private String title;

	@Column(name = "Content", length = 5000)
	@Size(max = 5000)
	@JsonProperty("Content")
	private String content;

	@Column(name = "Thumbnail", length = 5000)
	@Size(max = 5000)
	@JsonProperty("Thumbnail")
	private String thumbnail;

	// Getters & Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
