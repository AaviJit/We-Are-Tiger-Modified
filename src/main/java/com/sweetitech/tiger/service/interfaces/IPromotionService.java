package com.sweetitech.tiger.service.interfaces;

import com.sweetitech.tiger.model.Banner;
import com.sweetitech.tiger.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPromotionService {

	Promotion findById(Long id);

	Promotion addPromotion(Promotion promotion);

	Page<Promotion> findAllPromotion (int id);

	Promotion updatePromotion(Promotion promotion);

	String sendPromotionNotification(Promotion promotion);
	
	void deletePromotion(Promotion promotion);
}
