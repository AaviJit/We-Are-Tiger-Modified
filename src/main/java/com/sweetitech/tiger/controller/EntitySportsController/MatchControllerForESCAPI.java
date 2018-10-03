//package com.sweetitech.tiger.controller.EntitySportsController;
//
//
//import com.sweetitech.tiger.model.cricketapi.Card;
//import com.sweetitech.tiger.model.cricketapi.CardCustomForOni;
//import com.sweetitech.tiger.service.EntitySportsService.EntitySportsCricketApiService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class MatchControllerForESCAPI {
//
//    @Autowired
//    EntitySportsCricketApiService entitySportsCricketApiService;
//
//    @GetMapping("/showSummary")
//    @ResponseBody
//    public ResponseEntity<CardCustomForOni> getMatchInfo()
//    {
//        return new ResponseEntity<CardCustomForOni>(entitySportsCricketApiService.getAllTypeMatch(), HttpStatus.OK);
//    }
//
//    @GetMapping("/recent")
//    @ResponseBody
//    public ResponseEntity<List<Card>> showRecentMatchs() {
//        return new ResponseEntity<List<Card>>(entitySportsCricketApiService.getRecentMatches(),HttpStatus.OK);
//    }
//
//
//    @GetMapping("/upcoming")
//    @ResponseBody
//    public ResponseEntity<List<Card>> showUpcommingMatchs() {
//        return new ResponseEntity<List<Card>>(entitySportsCricketApiService.getUpcomingMatchs(),HttpStatus.OK);
//    }
//
//    @GetMapping("/live")
//    @ResponseBody
//    public ResponseEntity<List<Card>> showCurrentMatchs() {
//        return new ResponseEntity<List<Card>>(entitySportsCricketApiService.getCurrentMatches(),HttpStatus.OK);
//    }
//}
