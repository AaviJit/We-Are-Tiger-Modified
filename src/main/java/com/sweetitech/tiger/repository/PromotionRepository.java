package com.sweetitech.tiger.repository;

import com.sweetitech.tiger.model.Banner;
import com.sweetitech.tiger.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("promotionRepository")
public interface PromotionRepository extends JpaRepository<Promotion, Integer>{

	 
	 public Promotion findById(Long id);
	 
	 public Promotion save(Promotion promotion);
	
	 public Page<Promotion> findAllByOrderByCreatedAtAsc (Pageable pageable);
}

