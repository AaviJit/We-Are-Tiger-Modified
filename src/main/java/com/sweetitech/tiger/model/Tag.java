package com.sweetitech.tiger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sweetitech.tiger.model.ecommerce.Product;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "created_at")
	public Date createdAt;

	@Column(columnDefinition = "LONGTEXT")
	private String tag;

    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.ALL
            },
            mappedBy = "tag")
	@JsonBackReference
    private List<GalleryImage> galleryImages = new ArrayList<GalleryImage>();
    
    

	public Tag(String tag) {
		super();
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", createdAt=" + createdAt + ", tag=" + tag + ", galleryImages=" + galleryImages + "]";
	}

	public Tag(String tag, List<GalleryImage> galleryImages) {
		super();
		this.tag = tag;
		this.galleryImages = galleryImages;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<GalleryImage> getGalleryImages() {
		return galleryImages;
	}

	public void setGalleryImages(List<GalleryImage> galleryImages) {
		this.galleryImages = galleryImages;
	}

	public Tag() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

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

}