package com.sweetitech.tiger.service;

import com.sweetitech.tiger.config.Constants;
import com.sweetitech.tiger.model.WIC;
import com.sweetitech.tiger.model.TopUpdate;
import com.sweetitech.tiger.repository.WICRepository;
import com.sweetitech.tiger.service.interfaces.IWICService;
import com.sweetitech.tiger.service.interfaces.ITopUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class WICService implements IWICService {

	@Autowired
	WICRepository wicRepository;
	

	
	@Override
	public WIC addWIC(WIC wic) {

		 return wicRepository.save(wic);
		
	}
	@Override
	public Page<WIC> findAllWIC(int page) {
		
		PageRequest request =
	            new PageRequest(page, Constants.PAGE_SIZE, Sort.Direction.DESC, "id");
		
	        return wicRepository.findAll(request);
	}

	@Override
	public List<WIC> findAll() {
		return wicRepository.findAll();
	}

	@Override
	public WIC findById(Long id) {
		
		return wicRepository.findById(id);
	}
	@Override
	public WIC updateWIC(WIC wic) {
		return wicRepository.save(wic);
		
	}

	@Override
	public void deleteWIC(WIC wic) {
		
		wicRepository.delete(wic);
	}

	@Override
	public Page<WIC> findAllByNameContaining(String name, int page) {
		PageRequest request =
				new PageRequest(page, Constants.PAGE_SIZE, Sort.Direction.DESC, "id");

		return wicRepository.findAllByNameContaining(name, request);

	}

	@Override
	public Page<WIC> findAllByDivision(String division, int page) {
		PageRequest request =
				new PageRequest(page, Constants.PAGE_SIZE, Sort.Direction.DESC, "id");

		return wicRepository.findAllByNameContaining(division, request);
	}


}
