package com.sweetitech.tiger.model.cricketapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flag")
public class Flag {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;


	@Column(columnDefinition = "LONGTEXT", nullable = false)
	public String url;

	@Column(columnDefinition = "LONGTEXT")
	public String name;
	
	@Column(unique = true, nullable = false)
	public String shortCode;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	public Flag() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public Flag(String url, String name, String shortCode) {
		super();
		this.url = url;
		this.name = name;
		this.shortCode = shortCode;
	}

	

	
}