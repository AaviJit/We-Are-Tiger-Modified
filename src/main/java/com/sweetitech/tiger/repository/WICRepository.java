package com.sweetitech.tiger.repository;

import com.sweetitech.tiger.model.Banner;
import com.sweetitech.tiger.model.WIC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wicRepository")
public interface WICRepository extends JpaRepository<WIC, Integer>{
	

	 
	 public WIC findById(Long id);
	 
	 public WIC save(WIC wic);

	Page<WIC> findAllByDivision(String division, Pageable pageRequest);
	Page<WIC> findAllByNameContaining(String name, Pageable pageRequest);

}

