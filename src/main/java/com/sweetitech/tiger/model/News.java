package com.sweetitech.tiger.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "news")
public class News {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;

    private String title;

    @Column(columnDefinition="LONGTEXT")
    private String summary;

    @Column(columnDefinition="LONGTEXT")
    private String description;

    @Column(name = "created_at")
    public Date createdAt;


//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinTable(name = "top_updates", joinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"))
//    
   
   @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(name = "news_image", joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id"))
   private Image featruedImage;
   
   
   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(name = "news_additional_images", joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id"))
   private List<Image> additionalImage = new ArrayList<Image>();
   
   
   
//   @OneToMany(fetch = FetchType.LAZY)
//   @JoinTable(name = "news_comments", joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"))
//   private List<Comment> comments;
   
   
   
//    public List<Comment> getComments() {
//	return comments;
//}
//
//public void setComments(List<Comment> comments) {
//	this.comments = comments;
//}
   
   
   

	public List<Image> getAdditionalImage() {
	return additionalImage;
}

public void setAdditionalImage(List<Image> additionalImage) {
	this.additionalImage = additionalImage;
}

	public Image getFeatruedImage() {
	return featruedImage;
}

public void setFeatruedImage(Image featruedImage) {
	this.featruedImage = featruedImage;
}


public News(long id, String title, String summary, String description, Image featruedImage) {
	super();
	this.id = id;
	this.title = title;
	this.summary = summary;
	this.description = description;
	this.featruedImage = featruedImage;
}


	public News(String title, String summary, String description, Image featruedImage) {
		super();
		this.title = title;
		this.summary = summary;
		this.description = description;
		this.featruedImage = featruedImage;
	}

	public News() {
        super();
       
    }

    public Long getId() {
        return id;
    }

    
    public void setId(final Long id) {
        this.id = id;
    }
    

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", summary=" + summary + ", description=" + description + "]";
	}
	 @PrePersist
	  void createdAt() {
	    this.createdAt = new Date();
	  }

	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.000 ", timezone="UTC")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


}