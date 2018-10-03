package com.sweetitech.tiger.controller;

import com.sweetitech.tiger.model.*;
import com.sweetitech.tiger.service.interfaces.IImageService;
import com.sweetitech.tiger.service.interfaces.IWICService;
import com.sweetitech.tiger.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/wic")
public class WICController {

	@Value("${user.privilege.read}")
	private String READ_PRIVILEGE;

	@Value("${user.privilege.write}")
	private String WRITE_PRIVILEGE;

	@Value("${user.privilege.changePassword}")
	private String CHANGE_PASSWORD_PRIVILEGE;

	@Value("${user.role.admin}")
	private String ROLE_ADMIN;

	@Value("${user.role.user}")
	private String ROLE_USER;

	@Autowired
	private IUserService userService;

	@Autowired
	private IImageService imageService;

	@Autowired
	IWICService wicService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createNewWIC(@Valid Principal principal,

			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "division", required = true) String division,
			@RequestParam(value = "phone", required = true) String phone,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "latitude", required = true) Float latitude,
			@RequestParam(value = "longitude", required = true) Float longitude
	) {



		if (hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {


			WIC n = wicService.addWIC(new WIC(latitude, longitude, division, address,phone,email,name));

			//System.out.println("returned stuff" + n.getDescription());

			return new ResponseEntity<WIC>(n, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("You do not have the permission to do so", HttpStatus.FORBIDDEN);
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updateWIC(@Valid Principal principal,

			@RequestParam(value = "id", required = true) long id,
									   @RequestParam(value = "name", required = false) String name,
									   @RequestParam(value = "address", required = false) String address,
									   @RequestParam(value = "division", required = false) String division,
									   @RequestParam(value = "phone", required = false) String phone,
									   @RequestParam(value = "email", required = false) String email,
									   @RequestParam(value = "latitude", required = false) Float latitude,
									   @RequestParam(value = "longitude", required = false) Float longitude

	) {

		if (hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {

			WIC wicTobeUpdated = wicService.findById(id);

			if (name != null && name != "") {
				wicTobeUpdated.setName(name);
			}

			if (address != null && address != "") {
				wicTobeUpdated.setAddress(address);
			}

			if (division != null && division != "") {
				wicTobeUpdated.setDivision(division);
			}

			if (phone != null && phone != "") {
				wicTobeUpdated.setPhone(phone);
			}

			if (email != null && email != "") {

				wicTobeUpdated.setEmail(email);
			}

			if (latitude != null && latitude != 0) {

				wicTobeUpdated.setLatitude(latitude);
			}
			if (longitude != null && longitude != 0) {

				wicTobeUpdated.setLongitude(longitude);
			}

			WIC n = wicService.updateWIC(wicTobeUpdated);

			return new ResponseEntity<WIC>(n, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("You do not have the permission to do so", HttpStatus.FORBIDDEN);
		}

	}



	// returns lastest PAGE_SIZE number of wic
	@GetMapping("/")
	public @ResponseBody Page<WIC> showAllWIC() {

		Page<WIC> wicList = wicService.findAllWIC(0);
		return wicList;
	}
	@GetMapping("/page")
	public @ResponseBody Page<WIC> showAllWICByPage(@RequestParam(value = "page", required = true) int page) {

		Page<WIC> wicList = wicService.findAllWIC(page);
		return wicList;
	}



	@GetMapping("/id")
	public @ResponseBody WIC showWIC(@RequestParam(value = "id", required = true) Long id) {

		WIC wic = wicService.findById(id);
		if (wic != null) {
			return wic;
		} else {

			return null;
		}

	}

	@GetMapping("/searchByDivision")
	public @ResponseBody Page<WIC> searchWICByDivision(@RequestParam(value = "divison", required = true) String divison) {

		Page<WIC> searchList = wicService.findAllByDivision (divison, 0);
		if (searchList != null) {
			return searchList;
		} else {

			return null;
		}

	}

	@GetMapping("/searchByDivision/page")
	public @ResponseBody Page<WIC> searchWICByDivisionPage(@RequestParam(value = "divison", required = true) String divison, @RequestParam(value = "page", required = true) int page) {

		Page<WIC> searchList = wicService.findAllByDivision (divison, page);
		if (searchList != null) {
			return searchList;
		} else {

			return null;
		}

	}

	@GetMapping("/searchByName")
	public @ResponseBody Page<WIC> searchWICbyName(@RequestParam(value = "name", required = true) String name) {

		Page<WIC> searchList = wicService.findAllByNameContaining (name, 0);
		if (searchList != null) {
			return searchList;
		} else {

			return null;
		}

	}

	@GetMapping("/searchByName/page")
	public @ResponseBody Page<WIC> searchWICbyNamePage(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "page", required = true) int page) {

		Page<WIC> searchList = wicService.findAllByNameContaining (name, page);
		if (searchList != null) {
			return searchList;
		} else {

			return null;
		}

	}



	@GetMapping("/delete")
	public @ResponseBody ResponseEntity<?> deleteWIC(@Valid Principal principal,
			@RequestParam(value = "id", required = true) long id) {
		if (hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {
			WIC wic = wicService.findById(id);
			wicService.deleteWIC(wic);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("You do not have the permission to do so", HttpStatus.FORBIDDEN);
		}
	}

	private boolean hasPrivilege(String privilege, User user) {

		boolean flag = false;

		Iterator<Role> roles = user.getRoles().iterator();
		while (roles.hasNext()) {
			Role r = roles.next();
			Iterator<Privilege> privileges = r.getPrivileges().iterator();
			while (privileges.hasNext()) {
				Privilege privilege1 = privileges.next();
				if (privilege1.getName().equals(privilege)) {
					flag = true;
					break;
				}
			}
		}
		return flag;

	}
}