package com.sweetitech.tiger.controller;

import com.sweetitech.tiger.model.*;
import com.sweetitech.tiger.service.interfaces.IPromotionService;
import com.sweetitech.tiger.service.interfaces.IImageService;
import com.sweetitech.tiger.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Iterator;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {

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
	IPromotionService promotionService;
	


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Promotion> createPromotion(@Valid Principal principal,
			@RequestParam(value = "landingUrl", required = true) String landingUrl,
			@RequestParam(value = "imageId", required = true) long imageId,
			@RequestParam(value = "content", required = true) String content,
			@RequestParam(value = "title", required = true) String title
													 ) {

		if(hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {
			Image image = imageService.findById(imageId);

			//PromotionSize promotionSize = promotionSizeRepository.findById(promotionSizeId);

			Promotion promotion = promotionService.addPromotion(new Promotion(title, landingUrl, content,  image));

			//

			return new ResponseEntity(promotion, HttpStatus.OK);
		}else {
			return new ResponseEntity("You do not have the permission to do so", HttpStatus.FORBIDDEN);
		}

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Promotion> updatePromotion(@Valid Principal principal,
			@RequestParam("landingUrl") String landingUrl,
			@RequestParam("imageId") Long imageId,
		   @RequestParam(value = "content") String content,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "id", required = true) Long id) {

		if(hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {
			Image image = imageService.findById(imageId);
			
		//	PromotionSize promotionSize = promotionSizeRepository.findById(promotionSizeId);
			
			Promotion toBeUpdated = promotionService.findById(id);
			 
			 if(landingUrl !=null && landingUrl !="") {
				 toBeUpdated.setLandingUrl(landingUrl);
			 }
			 
			 if(imageId !=null && imageId != 0) {
				 toBeUpdated.setImage(imageService.findById(imageId));
			 }
			if(content !=null && content != "") {
				toBeUpdated.setContent(content);
			}
			if(title !=null && title != "") {
				toBeUpdated.setTitle(title);
			}

			Promotion promotion = promotionService.updatePromotion(toBeUpdated);
			
			return new ResponseEntity(promotion, HttpStatus.OK);
		}else {
			return new ResponseEntity("You do not have the permission to do so", HttpStatus.FORBIDDEN);
		}

	}
	
	@GetMapping("/delete")
	public @ResponseBody ResponseEntity<?> deletePromotion(@Valid Principal principal,
			@RequestParam(value = "id", required = true) long id){
		if(hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {
			Promotion promotion = promotionService.findById(id);
			promotionService.deletePromotion(promotion);
			return new ResponseEntity("Deleted", HttpStatus.OK);
		}else {
			return new ResponseEntity("You do not have the permission to do so", HttpStatus.FORBIDDEN);
		}
	}

	
	
	
	@GetMapping("/")
	public @ResponseBody Page<Promotion> showAllPromotion() {

		Page<Promotion> promotionList = promotionService.findAllPromotion(0);
		return promotionList;
	}

	@GetMapping("/page")
	public @ResponseBody Page<Promotion> showAllPromotionByPage(@RequestParam(value = "id", required = true) int id) {

		Page<Promotion> galleryImageList = promotionService.findAllPromotion(id);

		return galleryImageList;
	}

	@GetMapping("/id")
	public @ResponseBody Promotion showPromotion(@RequestParam(value = "id", required = true) Long id) {

		Promotion promotion = promotionService.findById(id);
		if (promotion != null) {
			return promotion;
		} else {

			return null;
		}

	}


	@RequestMapping(value = "/notify", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?>  sendOutNotification(@RequestParam(value = "id", required = true) Long id) {

		Promotion promotion = promotionService.findById(id);
		if (promotion != null) {


			return new ResponseEntity<String>(promotionService.sendPromotionNotification(promotion), HttpStatus.OK) ;
		} else {

			return new ResponseEntity<String>("Not a promotion", HttpStatus.OK) ;
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
				if(privilege1.getName().equals(privilege)) {
					flag = true;
					break;
				}
			}
		}
		return flag;

	}
}