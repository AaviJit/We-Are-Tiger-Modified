package com.sweetitech.tiger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.sweetitech.tiger.dto.UserDto;

import com.sweetitech.tiger.exception.UserAlreadyExistException;
import com.sweetitech.tiger.model.User;
import com.sweetitech.tiger.repository.UsersRepository;
import com.sweetitech.tiger.service.interfaces.IUserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private IUserService userService;

	@Autowired
	private UsersRepository userRepository;

	// @Autowired
	// private AuthenticationManager authenticationManager;

	public RegistrationController() {
		super();
	}

	// Registration

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> registerUserAccount(

			@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber) {

		// always register as a user id =1
		//
		if((firstName != null || firstName.equals(""))
				
				&& (password != null || password.equals(""))
				&& (email !=null || email.equals(""))
				){
			UserDto accountDto = new UserDto(firstName, lastName, password, email, phoneNumber, 1);

			try {
				final User registered = userService.registerNewUserAccount(accountDto);
				if (registered == null) {

					return new ResponseEntity<>("Some thing went wrong. Plpease check your parameters and try again.",
							HttpStatus.BAD_REQUEST);
				}

				return new ResponseEntity<>("User successfully registered! Yay!", HttpStatus.OK);// HttpStatus.ACCEPTED;

			} catch (UserAlreadyExistException uae) {

				return new ResponseEntity<>(uae.getMessage(), HttpStatus.CONFLICT);

			} catch (Exception a) {

				return new ResponseEntity<>("Some thing went wrong. Please check your parameters and try again.",
						HttpStatus.BAD_REQUEST);
			}
		}else{
			return new ResponseEntity<>("Field missing",
					HttpStatus.BAD_REQUEST);
		}


	}

	

	
}
