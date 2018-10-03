package com.sweetitech.tiger.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;

import javax.validation.Valid;

import com.sweetitech.tiger.model.*;
import com.sweetitech.tiger.service.EmailService;
import com.sweetitech.tiger.service.interfaces.IEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sweetitech.tiger.dto.UserProfileDto;

import com.sweetitech.tiger.config.Constants;
import com.sweetitech.tiger.service.interfaces.IImageService;
import com.sweetitech.tiger.service.interfaces.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Value("${user.privilege.write}")
	private String WRITE_PRIVILEGE;

	@Autowired
	private IUserService userService;

	@Autowired
    private IEmailService emailService;

	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private IImageService imageService;

	@GetMapping("/email")
	public String userName(Principal principal) {
		String a = principal.getName();
		return a;
	}

	@GetMapping("/")
	public UserProfileDto user(Principal principal) {
		String a = principal.getName();

		return userService.findUserProfileDtoByEmail(a);

	}

	@GetMapping("/upload/profile-picture")
	public ResponseEntity<?> uploadProfilePicture(Principal principal,
			@RequestParam(value = "imageId", required = true) long imageId) {
		String a = principal.getName();

		Image newProfilePicture = imageService.findById(imageId);
		User user = userService.findUserByEmail(a);
		user.setProfilePicture(newProfilePicture);
		userService.saveRegisteredUser(user);
		// imageService.deleteImage(user.getProfilePicture());
		return new ResponseEntity("Profile Picture updated", HttpStatus.OK);
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updateUser(
			@Valid Principal principal,
			@RequestParam(value = "password", required = true) String password) {

		User u =userService.findUserByEmail(principal.getName());
		u.setPassword(password);
		userService.saveRegisteredUserWithChangedPassword(u);
		return new ResponseEntity("Password Changed!", HttpStatus.OK);

	}
	@RequestMapping(value = "/requestResetPassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> requestResetPassword(

            @RequestParam(value = "email", required = true) String email) {

		User user =userService.findUserByEmail(email);

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);

        emailService.sendSimpleMessage(user.getEmail(), "Password Reset", "Please use this token to reset your password: "+token);

		return new ResponseEntity("Password change requested!", HttpStatus.OK);

	}

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> resetPassword(

            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "newPassword", required = true) String newPassword
            ) {

        PasswordResetToken passToken = userService.getPasswordResetToken(token);
        if(passToken == null){
            return new ResponseEntity("Invalid token!", HttpStatus.BAD_REQUEST);
        }else{
            Calendar cal = Calendar.getInstance();
            if ((passToken.getExpiryDate()
                    .getTime() - cal.getTime()
                    .getTime()) <= 0) {
                return new ResponseEntity("Token expired!", HttpStatus.BAD_REQUEST);
            }else{
                User u = passToken.getUser();
                u.setPassword(newPassword);
                userService.saveRegisteredUserWithChangedPassword(u);
                return new ResponseEntity("Password Changed!", HttpStatus.OK);
            }
        }
    }

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updateUser(@Valid Principal principal,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber,
			@RequestParam(value = "profilePicture", required = false) Long profilePicture,
			@RequestParam(value = "email", required = false) String email

	) {

		User userTobeUpdated = userService.findUserByEmail(principal.getName());

		if (firstName != null && firstName != "") {
			userTobeUpdated.setFirstName(firstName);
		}

		if (lastName != null && lastName != "") {
			userTobeUpdated.setLastName(lastName);
		}

		if (phoneNumber != null && phoneNumber != "") {
			userTobeUpdated.setPhoneNumber(phoneNumber);
		}

		if (email != null && email != "") {
			userTobeUpdated.setEmail(email);
		}

		if (profilePicture != null && profilePicture != 0) {
			userTobeUpdated.setProfilePicture(imageService.findById(profilePicture));
		}

		

		userService.saveRegisteredUser(userTobeUpdated);
		return new ResponseEntity("Profile updated!", HttpStatus.OK);

	}
	

	@GetMapping("/showAllUsers")
	public @ResponseBody ResponseEntity<Page<UserProfileDto>> showAllUsers(Principal principal) {

		if (hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {
			//Page<UserProfileDto> usersList = userService.findAllUser(0);

			Page<User> usersListPage = userService.findAllUserByRoles_Name(Constants.ROLE_USER, 0);

			
			Page<UserProfileDto> pp =   usersListPage.map(new Converter<User, UserProfileDto>() {
			    @Override
			    public UserProfileDto convert(User entity) {
			    //	UserProfileDto dto = new UserProfileDto();
			        // Conversion logic

			        return convertToDto(entity);
			    }
			});  //new PageImpl<UserProfileDto>(userProfileDtoList);
			
			return new ResponseEntity(pp, HttpStatus.OK);
		} else {
			return new ResponseEntity("You do not have the permission to do so", HttpStatus.FORBIDDEN);
		}

	}
	
	@GetMapping("/showAllUsers/page")
	public @ResponseBody ResponseEntity<Page<UserProfileDto>> showAllUsersByPage(Principal principal, @RequestParam(value = "pageId", required = true) int pageId) {

		if (hasPrivilege(WRITE_PRIVILEGE, userService.findUserByEmail(principal.getName()))) {
			//Page<UserProfileDto> usersList = userService.findAllUser(0);

			Page<User> usersListPage = userService.findAllUserByRoles_Name(Constants.ROLE_USER, pageId);

			
			Page<UserProfileDto> pp =   usersListPage.map(new Converter<User, UserProfileDto>() {
			    @Override
			    public UserProfileDto convert(User entity) {
			    //	UserProfileDto dto = new UserProfileDto();
			        // Conversion logic

			        return convertToDto(entity);
			    }
			});  //new PageImpl<UserProfileDto>(userProfileDtoList);
			
			return new ResponseEntity(pp, HttpStatus.OK);
		} else {
			return new ResponseEntity("You do not have the permission to do so", HttpStatus.FORBIDDEN);
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
	
	
	private UserProfileDto convertToDto(User user) {
		UserProfileDto userProfileDto = modelMapper.map(user, UserProfileDto.class);
		String sb = "";
        Iterator<Role> roles = user.getRoles().iterator();
		while (roles.hasNext()) {
			Role r = roles.next();
			sb = r.getName();
		}
		userProfileDto.setRole(sb);
		
	    return userProfileDto;
	}
}
