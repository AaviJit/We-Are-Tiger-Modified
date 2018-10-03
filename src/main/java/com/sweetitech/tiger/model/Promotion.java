package com.sweetitech.tiger.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "promotion")
public class Promotion {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(columnDefinition = "LONGTEXT")
	public String landingUrl;

	@Column(columnDefinition = "LONGTEXT")
	public String title;

	@Column(columnDefinition = "LONGTEXT")
	public String content;

	@Column(name = "created_at")
	public Date createdAt;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "promotion_image", joinColumns = @JoinColumn(name = "promotion_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id"))
	public Image image;



	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.000 ", timezone = "UTC")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLandingUrl() {
		return landingUrl;
	}

	public void setLandingUrl(String landingUrl) {
		this.landingUrl = landingUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Promotion(String title, String landingUrl, String content,  Image image) {
		this.landingUrl = landingUrl;
		this.content = content;
		this.title = title;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Promotion() {
		super();
	}
}