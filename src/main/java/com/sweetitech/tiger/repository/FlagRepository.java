package com.sweetitech.tiger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweetitech.tiger.model.cricketapi.Flag;

@Repository("flagRepository")
public interface FlagRepository extends JpaRepository<Flag, Integer>{
	
	 public List<Flag> findAllByOrderByIdAsc();
	 
	 public Flag findById(Long id);
	 
	 public Flag save(Flag flag);
	
	public Flag findByShortCode(String shortCode);
}

