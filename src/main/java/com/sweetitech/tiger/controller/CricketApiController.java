package com.sweetitech.tiger.controller;

import java.util.List;

import com.sweetitech.tiger.service.EntitySportsService.EntitySportsCricketApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweetitech.tiger.model.cricketapi.Card;
import com.sweetitech.tiger.model.cricketapi.CardCustomForOni;
import com.sweetitech.tiger.model.cricketapi.CardCustomForOniHome;
import com.sweetitech.tiger.model.cricketapi.CustomOniObjectForShortCard;
import com.sweetitech.tiger.model.cricketapi.Data;
import com.sweetitech.tiger.service.interfaces.ICricketApiService;

@RestController
@RequestMapping("/api/match")
public class CricketApiController {

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



	//my code start here (Avijit Barua)
	@Autowired
	private ICricketApiService cricketApiService;

	@Autowired
	EntitySportsCricketApiService entitySportsCricketApiService;

    //controller working good
	@GetMapping("/live")
	@ResponseBody
	public ResponseEntity<List<Card>> showCurrentMatchs() {
		return new ResponseEntity<List<Card>>(entitySportsCricketApiService.getCurrentMatches(),HttpStatus.OK);
	}
	//controller working good
	@GetMapping("/upcoming")
	@ResponseBody
	public ResponseEntity<List<Card>> showUpcommingMatchs() {
		return new ResponseEntity<List<Card>>(entitySportsCricketApiService.getUpcomingMatchs(),HttpStatus.OK);
	}
	//controller working good
	@GetMapping("/recent")
	@ResponseBody
	public ResponseEntity<List<Card>> showRecentMatchs() {
		return new ResponseEntity<List<Card>>(entitySportsCricketApiService.getRecentMatches(),HttpStatus.OK);
	}

	//controller working good
	@GetMapping("/recent/shortCard")
	@ResponseBody
	public ResponseEntity<CustomOniObjectForShortCard>  shortRecentCard() {
		return new ResponseEntity<CustomOniObjectForShortCard>(entitySportsCricketApiService.getRecentMatchesShortCard(), HttpStatus.OK);
	}




   //my code ends here

	//controller working good
	@GetMapping("/showSummary")
	@ResponseBody
	public ResponseEntity<CardCustomForOni> getMatchInfo(@RequestParam("matchKey") String matchKey)
	{
		return new ResponseEntity<CardCustomForOni>(entitySportsCricketApiService.getMatchInfo(matchKey), HttpStatus.OK);
	}






























	@GetMapping("/showSummaryRaw")
	@ResponseBody
	public ResponseEntity<Card> showSummaryRaw(@RequestParam("matchKey") String matchKey) {


		return new ResponseEntity<Card>(cricketApiService.getMatchSummary(matchKey), HttpStatus.OK);
	}

	@GetMapping("/getPastAndFuture")
	@ResponseBody
	public List<Card> showPastMatchs() {
		return cricketApiService.getPastAndFuture();
	}
	
	@GetMapping("/live/shortCard")
	@ResponseBody
	public ResponseEntity<List<CardCustomForOniHome>>  shortLiveCard() {

		return new ResponseEntity<List<CardCustomForOniHome>>(cricketApiService.getLiveMatchesShortCard(), HttpStatus.OK); 
		
	}

	@GetMapping("/upcoming/shortCard")
	@ResponseBody
	public ResponseEntity<List<CardCustomForOniHome>>  shortUpcomingCard() {

		return new ResponseEntity<List<CardCustomForOniHome>>(cricketApiService.getUpcomingMatchesShortCard(), HttpStatus.OK);
	}
	
	@GetMapping("/id")
	@ResponseBody
	public ResponseEntity<Data>  showAllBanner(
			@RequestParam("matchKey") String matchKey) {

		return new ResponseEntity<Data>(cricketApiService.getMatchById(matchKey), HttpStatus.OK); 
		
	}
	
}