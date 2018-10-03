package com.sweetitech.tiger.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sweetitech.tiger.config.Constants;
import com.sweetitech.tiger.model.Banner;
import com.sweetitech.tiger.model.Tag;
import com.sweetitech.tiger.repository.TagRepository;
import com.sweetitech.tiger.service.interfaces.ITagService;

@Service
@Transactional
public class TagService implements ITagService {

	@Autowired
	TagRepository tagRepository;

	@Override
	public Tag addTag(Tag tag) {

		return tagRepository.save(tag);
	}

	@Override
	public Tag findById(Long id) {

		return tagRepository.findById(id);
	}

	@Override
	public Tag findByTag(String tag) {

		return tagRepository.findByTag(tag);
	}

	@Override
	public Page<Tag> findAll(int page) {
		PageRequest request =
	            new PageRequest(page, Constants.PAGE_SIZE, Sort.Direction.DESC, "id");
		return tagRepository.findAll(request);
	}

	@Override
	public Tag updateTag(Tag tag) {

		return tagRepository.save(tag);
	}

	@Override
	public void deleteTag(Tag tag) {

		tagRepository.delete(tag);
	}

}
