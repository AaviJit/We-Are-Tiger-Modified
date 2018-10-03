package com.sweetitech.tiger.service.interfaces;

import com.sweetitech.tiger.model.WIC;
import com.sweetitech.tiger.model.WIC;
import org.springframework.data.domain.Page;


public interface IWICService {

	WIC addWIC(WIC wic);
	Page<WIC> findAllWIC(int page);
	//void deleteWIC(WIC news);
	WIC findById(Long id);

	WIC updateWIC(WIC wic);
	void deleteWIC(WIC wic);
	
	Page<WIC> findAllByNameContaining(String name, int page);
	Page<WIC> findAllByDivision(String division, int page);
}
