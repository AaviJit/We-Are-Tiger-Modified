package com.sweetitech.tiger.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import com.sweetitech.tiger.model.cricketapi.*;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sweetitech.tiger.config.Constants;
import com.sweetitech.tiger.config.ObjectMapperProvider;
import com.sweetitech.tiger.repository.FlagRepository;
import com.sweetitech.tiger.service.interfaces.ICricketApiService;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service("cricketApiService")
public class CricketApiService implements ICricketApiService {

	String authUrl;
	String matchUrl;
	String recentMatchUrl;
	String season_url;
	OkHttpClient client;



	public CricketApiService() {
		authUrl = Constants.CRICKET_API_BASE + "auth/";
		matchUrl = Constants.CRICKET_API_BASE + "match/";
		recentMatchUrl = Constants.CRICKET_API_BASE + "recent_matches/";
		season_url = Constants.CRICKET_API_BASE + "auth/";
		client = new OkHttpClient();
	}



	@Autowired
	HttpSession httpSession;

	@Autowired
	FlagRepository flagRepository;

	@Override
	public Data getMatchById(String matchId) {

		Request request = new Request.Builder().url(HttpUrl.parse(matchUrl + matchId + "/").newBuilder()
				.addQueryParameter("access_token", getAccessToken()).toString()).get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();

			ObjectMapperProvider mapper = new ObjectMapperProvider();

			return mapper.getContext(ObjectMapper.class).readValue(response.body().bytes(), Yo.class).getData();
			// readValue(response.body().bytes(), Yo.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public String getAccessToken() {
		return logIn().getAuth().getAccess_token();
	}

	public CricketApiLogin logIn() {

		RequestBody requestBody = new FormBody.Builder()
				.add(Constants.CRICKET_ACCESS_KEY_IDENTIFIER, Constants.CRICKET_ACCESS_KEY)
				.add(Constants.CRICKET_SECRET_KEY_IDENTIFIER, Constants.CRICKET_SECRET_KEY)
				.add(Constants.CRICKET_APP_ID_IDENTIFIER, Constants.CRICKET_APP_ID)
				.add(Constants.CRICKET_DEVICE_ID_IDENTIFIER, Constants.CRICKET_DEVICE_ID).build();

		Request request = new Request.Builder()

				.post(requestBody).addHeader("content-type", "application/x-www-form-urlencoded")
				.addHeader("cache-control", "no-cache").url(authUrl).build();

		try {
			Response response = client.newCall(request).execute();

			CricketApiLogin cricketApiLogin = new ObjectMapper().readValue(response.body().bytes(),
					CricketApiLogin.class);

			System.out.println("===========================" + cricketApiLogin.getAuth().getAccess_token());

			httpSession.setAttribute(Constants.CRICKET_API_SESSION_ACCESS_TOKEN_IDENTIFIER,
					cricketApiLogin.getAuth().getAccess_token());
			httpSession.setAttribute(Constants.CRICKET_SESSION_CACHE_KEY_IDENTIFIER, cricketApiLogin.getCache_key());
			httpSession.setAttribute(Constants.CRICKET_API_SESSION_ACCESS_TOKEN_EXPIRE_IDENTIFIER,
					cricketApiLogin.getAuth().getExpires());

			return cricketApiLogin;

		} catch (IOException e) {
			System.out.println(e.getMessage());

			httpSession.setAttribute(Constants.CRICKET_API_SESSION_ACCESS_TOKEN_IDENTIFIER, null);
			httpSession.setAttribute(Constants.CRICKET_SESSION_CACHE_KEY_IDENTIFIER, null);
			httpSession.setAttribute(Constants.CRICKET_API_SESSION_ACCESS_TOKEN_EXPIRE_IDENTIFIER, null);

			return null;
		}

	}

	@Override
	public List<Card> getRecentMatches() {

		Request request = new Request.Builder()
				.url(HttpUrl.parse(recentMatchUrl).newBuilder().addQueryParameter("access_token", getAccessToken())
						.addQueryParameter("card_type", "summary_card").toString())
				.get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo yo = new ObjectMapper().readValue(response.body().bytes(), Yo.class);
			List<Card> receivedCards = yo.getData().getCards();

			List<Card> tr = receivedCards.stream().filter(t -> t.getStatus().equals("completed"))
					.collect(Collectors.toList());

			for (int i = 0; i < tr.size(); i++) {
				Card c = tr.get(i);

				String[] a = c.getShort_name().split("vs");
				c.setTeam_a(a[0].replaceAll("\\s+", ""));
				c.setTeam_b(a[1].replaceAll("\\s+", ""));

				c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
				c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));

			}

			return tr;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Card> getPastAndFuture() {
		Request request = new Request.Builder()
				.url(HttpUrl.parse(recentMatchUrl).newBuilder().addQueryParameter("access_token", getAccessToken())
						.addQueryParameter("card_type", "micro_card").toString())
				.get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo yo = new ObjectMapper().readValue(response.body().bytes(), Yo.class);
			return yo.getData().getCards();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Card> getCurrentMatches() {
		Request request = new Request.Builder()
				.url(HttpUrl.parse(recentMatchUrl).newBuilder().addQueryParameter("access_token", getAccessToken())
						.addQueryParameter("card_type", "summary_card").toString())
				.get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo yo = new ObjectMapper().readValue(response.body().bytes(), Yo.class);
			List<Card> receivedCards = yo.getData().getCards();

			List<Card> tr = receivedCards.stream().filter(t -> t.getStatus().equals("started"))
					.collect(Collectors.toList());

			for (int i = 0; i < tr.size(); i++) {
				Card c = tr.get(i);

				String[] a = c.getShort_name().split("vs");
				c.setTeam_a(a[0].replaceAll("\\s+", ""));
				c.setTeam_b(a[1].replaceAll("\\s+", ""));

				c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
				c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));

			}

			return tr;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Card> getUpcomingMatchs() {
		Request request = new Request.Builder()
				.url(HttpUrl.parse(recentMatchUrl).newBuilder().addQueryParameter("access_token", getAccessToken())
						.addQueryParameter("card_type", "summary_card").toString())
				.get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo yo = new ObjectMapper().readValue(response.body().bytes(), Yo.class);
			List<Card> receivedCards = yo.getData().getCards();

			List<Card> tr = receivedCards.stream().filter(t -> t.getStatus().equals("notstarted"))
					.collect(Collectors.toList());

			for (int i = 0; i < tr.size(); i++) {
				Card c = tr.get(i);

				// getMatchSummary(c.getKey()).getNow().getR;

				String[] a = c.getShort_name().split("vs");
				c.setTeam_a(a[0].replaceAll("\\s+", ""));
				c.setTeam_b(a[1].replaceAll("\\s+", ""));

				c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
				c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));

			}

			return tr;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Card getMatchSummary(String key) {
		Request request = new Request.Builder().url(HttpUrl.parse(matchUrl + key + "/").newBuilder()
				.addQueryParameter("access_token", getAccessToken()).toString()).get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo2 yo = new ObjectMapper().readValue(response.body().bytes(), Yo2.class);
			Data2 data = yo.getData();

			Card c = data.getCard();
			String[] a = c.getShort_name().split("vs");
			c.setTeam_a(a[0].replaceAll("\\s+", ""));
			c.setTeam_b(a[1].replaceAll("\\s+", ""));

			c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
					: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
			c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
					: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));
			return data.getCard();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public CardCustomForOni getMatchSummaryCardCustomForOni(String key) {
		Request request = new Request.Builder().url(HttpUrl.parse(matchUrl + key + "/").newBuilder()
				.addQueryParameter("access_token", getAccessToken()).toString()).get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo2 yo = new ObjectMapper().readValue(response.body().bytes(), Yo2.class);
			Data2 data = yo.getData();

			Card c = data.getCard();
			String[] a = c.getShort_name().split("vs");
			c.setTeam_a(a[0].replaceAll("\\s+", ""));
			c.setTeam_b(a[1].replaceAll("\\s+", ""));

			c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
					: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
			c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
					: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));

			CardCustomForOni toBeReturned = new CardCustomForOni();

			toBeReturned.setTeam_a(c.getTeam_a());
			toBeReturned.setTeam_b(c.getTeam_b());
			toBeReturned.setTeam_a_url(c.getTeam_a_url());
			toBeReturned.setTeam_b_url(c.getTeam_b_url());
			toBeReturned.setRelated_name(c.getRelated_name());
			toBeReturned.setMsgs_result(c.getMsgs().getResult());
			toBeReturned.setMsgs_others(c.getMsgs().getOthers());
			toBeReturned.setToss_decision(c.getToss().getDecision());
			toBeReturned.setToss_str(c.getToss().getStr());
			toBeReturned.setToss_won(c.getToss().getWon());
			toBeReturned.setWinner_team(c.getWinner_team());

			toBeReturned.setInnings_A_1_batting_order(c.getInnings().getA_1().getBatting_order());
			toBeReturned.setInnings_A_1_runs(c.getInnings().getA_1().getRuns());
			toBeReturned.setInnings_A_1_balls(c.getInnings().getA_1().getBalls());
			toBeReturned.setInnings_A_1_fall_of_wickets(c.getInnings().getA_1().getFall_of_wickets());
			toBeReturned.setInnings_A_1_wide(c.getInnings().getA_1().getWide());
			toBeReturned.setInnings_A_1_run_rate(c.getInnings().getA_1().getRun_rate());
			toBeReturned.setInnings_A_1_fours(c.getInnings().getA_1().getFours());
			toBeReturned.setInnings_A_1_run_str(c.getInnings().getA_1().getRun_str());
			toBeReturned.setInnings_A_1_wickets(c.getInnings().getA_1().getWickets());
			toBeReturned.setInnings_A_1_wicket_order(c.getInnings().getA_1().getWicket_order());
			toBeReturned.setInnings_A_1_extras(c.getInnings().getA_1().getExtras());
			toBeReturned.setInnings_A_1_bowling_order(c.getInnings().getA_1().getBowling_order());
			toBeReturned.setInnings_A_1_key(c.getInnings().getA_1().getKey());
			toBeReturned.setInnings_A_1_noball(c.getInnings().getA_1().getNoball());
			toBeReturned.setInnings_A_1_sixes(c.getInnings().getA_1().getSixes());
			toBeReturned.setInnings_A_1_legbye(c.getInnings().getA_1().getLegbye());
			toBeReturned.setInnings_A_1_bye(c.getInnings().getA_1().getBye());
			toBeReturned.setInnings_A_1_overs(c.getInnings().getA_1().getOvers());
			toBeReturned.setInnings_A_1_dotballs(c.getInnings().getA_1().getDotballs());

			toBeReturned.setInnings_B_1_batting_order(c.getInnings().getB_1().getBatting_order());
			toBeReturned.setInnings_B_1_runs(c.getInnings().getB_1().getRuns());
			toBeReturned.setInnings_B_1_balls(c.getInnings().getB_1().getBalls());
			toBeReturned.setInnings_B_1_fall_of_wickets(c.getInnings().getB_1().getFall_of_wickets());
			toBeReturned.setInnings_B_1_wide(c.getInnings().getB_1().getWide());
			toBeReturned.setInnings_B_1_run_rate(c.getInnings().getB_1().getRun_rate());
			toBeReturned.setInnings_B_1_fours(c.getInnings().getB_1().getFours());
			toBeReturned.setInnings_B_1_run_str(c.getInnings().getB_1().getRun_str());
			toBeReturned.setInnings_B_1_wickets(c.getInnings().getB_1().getWickets());
			toBeReturned.setInnings_B_1_wicket_order(c.getInnings().getB_1().getWicket_order());
			toBeReturned.setInnings_B_1_extras(c.getInnings().getB_1().getExtras());
			toBeReturned.setInnings_B_1_bowling_order(c.getInnings().getB_1().getBowling_order());
			toBeReturned.setInnings_B_1_key(c.getInnings().getB_1().getKey());
			toBeReturned.setInnings_B_1_noball(c.getInnings().getB_1().getNoball());
			toBeReturned.setInnings_B_1_sixes(c.getInnings().getB_1().getSixes());
			toBeReturned.setInnings_B_1_legbye(c.getInnings().getB_1().getLegbye());
			toBeReturned.setInnings_B_1_bye(c.getInnings().getB_1().getBye());
			toBeReturned.setInnings_B_1_overs(c.getInnings().getB_1().getOvers());
			toBeReturned.setInnings_B_1_dotballs(c.getInnings().getB_1().getDotballs());

			if(c.getInnings().getB_2() != null){
				toBeReturned.setInnings_B_2_bowling_order(c.getInnings().getB_2().getBowling_order());

				toBeReturned.setInnings_B_2_batting_order(c.getInnings().getB_2().getBatting_order());
				toBeReturned.setInnings_B_2_runs(c.getInnings().getB_2().getRuns());
				toBeReturned.setInnings_B_2_balls(c.getInnings().getB_2().getBalls());
				toBeReturned.setInnings_B_2_fall_of_wickets(c.getInnings().getB_2().getFall_of_wickets());
				toBeReturned.setInnings_B_2_wide(c.getInnings().getB_2().getWide());
				toBeReturned.setInnings_B_2_run_rate(c.getInnings().getB_2().getRun_rate());
				toBeReturned.setInnings_B_2_fours(c.getInnings().getB_2().getFours());
				toBeReturned.setInnings_B_2_run_str(c.getInnings().getB_2().getRun_str());
				toBeReturned.setInnings_B_2_wickets(c.getInnings().getB_2().getWickets());
				toBeReturned.setInnings_B_2_wicket_order(c.getInnings().getB_2().getWicket_order());
				toBeReturned.setInnings_B_2_extras(c.getInnings().getB_2().getExtras());
				toBeReturned.setInnings_B_2_bowling_order(c.getInnings().getB_2().getBowling_order());
				toBeReturned.setInnings_B_2_key(c.getInnings().getB_2().getKey());
				toBeReturned.setInnings_B_2_noball(c.getInnings().getB_2().getNoball());
				toBeReturned.setInnings_B_2_sixes(c.getInnings().getB_2().getSixes());
				toBeReturned.setInnings_B_2_legbye(c.getInnings().getB_2().getLegbye());
				toBeReturned.setInnings_B_2_bye(c.getInnings().getB_2().getBye());
				toBeReturned.setInnings_B_2_overs(c.getInnings().getB_2().getOvers());
				toBeReturned.setInnings_B_2_dotballs(c.getInnings().getB_2().getDotballs());
			}
			if(c.getInnings().getA_2() != null){
				toBeReturned.setInnings_A_2_bowling_order(c.getInnings().getA_2().getBowling_order());


				toBeReturned.setInnings_A_2_batting_order(c.getInnings().getA_2().getBatting_order());
				toBeReturned.setInnings_A_2_runs(c.getInnings().getA_2().getRuns());
				toBeReturned.setInnings_A_2_balls(c.getInnings().getA_2().getBalls());
				toBeReturned.setInnings_A_2_fall_of_wickets(c.getInnings().getA_2().getFall_of_wickets());
				toBeReturned.setInnings_A_2_wide(c.getInnings().getA_2().getWide());
				toBeReturned.setInnings_A_2_run_rate(c.getInnings().getA_2().getRun_rate());
				toBeReturned.setInnings_A_2_fours(c.getInnings().getA_2().getFours());
				toBeReturned.setInnings_A_2_run_str(c.getInnings().getA_2().getRun_str());
				toBeReturned.setInnings_A_2_wickets(c.getInnings().getA_2().getWickets());
				toBeReturned.setInnings_A_2_wicket_order(c.getInnings().getA_2().getWicket_order());
				toBeReturned.setInnings_A_2_extras(c.getInnings().getA_2().getExtras());
				toBeReturned.setInnings_A_2_bowling_order(c.getInnings().getA_2().getBowling_order());
				toBeReturned.setInnings_A_2_key(c.getInnings().getA_2().getKey());
				toBeReturned.setInnings_A_2_noball(c.getInnings().getA_2().getNoball());
				toBeReturned.setInnings_A_2_sixes(c.getInnings().getA_2().getSixes());
				toBeReturned.setInnings_A_2_legbye(c.getInnings().getA_2().getLegbye());
				toBeReturned.setInnings_A_2_bye(c.getInnings().getA_2().getBye());
				toBeReturned.setInnings_A_2_overs(c.getInnings().getA_2().getOvers());
				toBeReturned.setInnings_A_2_dotballs(c.getInnings().getA_2().getDotballs());
			}



			toBeReturned.setDl_applied(c.getDl_applied());
			toBeReturned.setStatus(c.getStatus());

			toBeReturned.setDescription(c.getDescription());
			toBeReturned.setShort_name(c.getShort_name());
			toBeReturned.setFormat(c.getFormat());
			toBeReturned.setKey(c.getKey());
			toBeReturned.setDay(c.getDay());
			toBeReturned.setVenue(c.getVenue());
			toBeReturned.setName(c.getName());
			toBeReturned.setStart_date_iso(c.getStart_date().getIso());
			toBeReturned.setStart_date_str(c.getStart_date().getStr());
			toBeReturned.setStart_date_timestamp(c.getStart_date().getTimestamp());
			
			//toBeReturned.setPlayers(c.getPlayers());
			
			response = client.newCall(request).execute();
			 ObjectMapper mapper = new ObjectMapper();
				JsonNode rootNode = mapper.readTree(response.body().bytes());
				JsonNode dataNode = rootNode.get("data");
				JsonNode card = dataNode.get("card");
				JsonNode playersNode = card.get("players");

			int size_A_1 = toBeReturned.getInnings_A_1_batting_order().size();


				for(int g =0 ; g < size_A_1; g++) { //
					JsonNode playerNode = playersNode.get(toBeReturned.getInnings_A_1_batting_order().get(g));
					JsonNode inningsNode = playerNode.get("match").get("innings");
					//System.out.println(playerNode.toString());
					System.out.println(inningsNode);

					if(g ==0) {

						//System.out.println(g + "-> budded ->");

						toBeReturned.setInnings_A_1_batting_player_1_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_1_strike_rate(clean( aa1xx.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_1_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null){

							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if(ab0 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_2_sixes(clean(ab0.toString()));}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if(ab00 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_2_fours(clean(ab00.toString()));}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if(ab01 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_2_balls(clean(ab01.toString()));}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if(ab02 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_2_runs(clean(ab02.toString()));}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if(ab1 != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_2_out_comment(clean( ab1.toString()));}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_1_innings_2_strike_rate(clean( aa2xx.toString()));}

							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if(ab3 != null) {toBeReturned.setInnings_A_1_bowling_player_1_innings_2_maiden_overs(clean( ab3.toString()));}
						}


					}
					else if(g ==1) {

						//System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_2_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_2_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_2_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_2_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_2_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_2_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_2_innings_1_maiden_overs(clean( aa3.toString()));}
						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_2_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_2_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_2_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_2_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_2_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_2_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_2_innings_2_maiden_overs(clean(ab3.toString()));
							}

							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_2_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==2) {
						System.out.println(g + "-> budded ->");

						toBeReturned.setInnings_A_1_batting_player_3_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_3_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_3_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_3_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_3_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_3_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_3_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_3_innings_1_strike_rate(clean( aa1xx.toString()));}

						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_3_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_3_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_3_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_3_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_3_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_3_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_3_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==3) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_4_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_4_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_4_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_4_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_4_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_4_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_4_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_4_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_4_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_4_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_4_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_4_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_4_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_4_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_4_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==4) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_5_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_5_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_5_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_5_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_5_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_5_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_5_innings_1_maiden_overs(clean( aa3.toString()));}
						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_5_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_5_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_5_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_5_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_5_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_5_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_5_innings_2_maiden_overs(clean(ab3.toString()));
							}

							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_5_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==5) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_6_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_6_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_6_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_6_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_6_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_6_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_6_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_6_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_6_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_6_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_6_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_6_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_6_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_6_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_6_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==6) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_7_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_7_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_7_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_7_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_7_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_7_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_7_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_7_innings_1_strike_rate(clean( aa1xx.toString()));}

						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_7_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_7_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_7_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_7_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_7_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_7_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_7_innings_2_strike_rate(clean( aa2xx.toString()));}

						}

					}
					else if(g ==7) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_8_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_8_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_8_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_8_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_8_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_8_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_8_innings_1_maiden_overs(clean( aa3.toString()));}
						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_8_innings_1_strike_rate(clean( aa1xx.toString()));}

						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_8_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_8_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_8_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_8_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_8_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_8_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_8_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==8) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_9_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_9_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_9_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_9_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_9_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_9_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_9_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_9_innings_1_strike_rate(clean( aa1xx.toString()));}

						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {

							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_9_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_9_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_9_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_9_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_9_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_9_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_9_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==9) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_10_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_10_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null){
						JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
						if(ab0 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_2_sixes(clean(ab0.toString()));}
						JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
						if(ab00 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_2_fours(clean(ab00.toString()));}
						JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
						if(ab01 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_2_balls(clean(ab01.toString()));}
						JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
						if(ab02 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_2_runs(clean(ab02.toString()));}
						JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
						if(ab1 != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_2_out_comment(clean( ab1.toString()));}
						JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
						if(ab3 != null) {toBeReturned.setInnings_A_1_bowling_player_10_innings_2_maiden_overs(clean( ab3.toString()));}

							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_10_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==10) {

						System.out.println(g + "-> budded ->");


						toBeReturned.setInnings_A_1_batting_player_11_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_A_1_batting_player_11_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_A_1_batting_player_11_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_A_1_batting_player_11_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_A_1_batting_player_11_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_A_1_batting_player_11_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_A_1_bowling_player_11_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_A_1_batting_player_11_innings_1_strike_rate(clean( aa1xx.toString()));}

						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_A_1_batting_player_11_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_A_1_batting_player_11_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_A_1_batting_player_11_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_A_1_batting_player_11_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_A_1_batting_player_11_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_A_1_bowling_player_11_innings_2_maiden_overs(clean(ab3.toString()));
							}

							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_A_1_batting_player_11_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}



				}
				
				
				
				
				int size_B_1 = toBeReturned.getInnings_B_1_batting_order().size();

				for(int g =0 ; g < size_B_1; g++) {
					JsonNode playerNode = playersNode.get(toBeReturned.getInnings_B_1_batting_order().get(g));
					JsonNode inningsNode = playerNode.get("match").get("innings");
					System.out.println(playerNode.toString());

					if(g ==0) {
						toBeReturned.setInnings_B_1_batting_player_1_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_1_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_1_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_1_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_1_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_1_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_1_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_1_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_1_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_1_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_1_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_1_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_1_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_1_innings_2_maiden_overs(clean(ab3.toString()));
							}

							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_1_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
						}
					else if(g ==1) {
						toBeReturned.setInnings_B_1_batting_player_2_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_2_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_2_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_2_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_2_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_2_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_2_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_2_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_2_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_2_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_2_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_2_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_2_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_2_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_2_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
						}
					else if(g ==2) {
						toBeReturned.setInnings_B_1_batting_player_3_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_3_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_3_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_3_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_3_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_3_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_3_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_3_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_3_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_3_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_3_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_3_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_3_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_3_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_3_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==3) {
						toBeReturned.setInnings_B_1_batting_player_4_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_4_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_4_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_4_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_4_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_4_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_4_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_4_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_4_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_4_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_4_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_4_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_4_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_4_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_4_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==4) {
						toBeReturned.setInnings_B_1_batting_player_5_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_5_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_5_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_5_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_5_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_5_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_5_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_5_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_5_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_5_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_5_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_5_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_5_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_5_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_5_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==5) {
						toBeReturned.setInnings_B_1_batting_player_6_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_6_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_6_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_6_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_6_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_6_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_6_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_6_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_6_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_6_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_6_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_6_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_6_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_6_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_6_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==6) {
						toBeReturned.setInnings_B_1_batting_player_7_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_7_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_7_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_7_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_7_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_7_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_7_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_7_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_7_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_7_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_7_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_7_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_7_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_7_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_7_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==7) {
						toBeReturned.setInnings_B_1_batting_player_8_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if (aa0 != null) {
							toBeReturned.setInnings_B_1_batting_player_8_innings_1_sixes(clean(aa0.toString()));
						}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if (aa00 != null) {
							toBeReturned.setInnings_B_1_batting_player_8_innings_1_fours(clean(aa00.toString()));
						}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if (aa01 != null) {
							toBeReturned.setInnings_B_1_batting_player_8_innings_1_balls(clean(aa01.toString()));
						}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if (aa02 != null) {
							toBeReturned.setInnings_B_1_batting_player_8_innings_1_runs(clean(aa02.toString()));
						}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if (aa1 != null) {
							toBeReturned.setInnings_B_1_batting_player_8_innings_1_out_comment(clean(aa1.toString()));
						}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if (aa3 != null) {
							toBeReturned.setInnings_B_1_bowling_player_8_innings_1_maiden_overs(clean(aa3.toString()));
						}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_8_innings_1_strike_rate(clean( aa1xx.toString()));}



						JsonNode secondInnings = inningsNode.get("2");
						if (secondInnings != null) {


							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_8_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_8_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_8_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_8_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_8_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_8_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_8_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}

					else if(g ==8) {
						toBeReturned.setInnings_B_1_batting_player_9_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_9_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_9_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_9_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_9_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_9_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_9_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_9_innings_1_strike_rate(clean( aa1xx.toString()));}


						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_9_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_9_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_9_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_9_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_9_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_9_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_9_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==9) {
						toBeReturned.setInnings_B_1_batting_player_10_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_10_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_10_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_10_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_10_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_10_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_10_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_10_innings_1_strike_rate(clean( aa1xx.toString()));}



						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_10_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_10_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_10_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_10_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_10_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_10_innings_2_maiden_overs(clean(ab3.toString()));
							}

							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_10_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}
					else if(g ==10) {
						toBeReturned.setInnings_B_1_batting_player_11_full_name(clean(playerNode.get("fullname").toString()));
						JsonNode aa0 = inningsNode.get("1").get("batting").get("sixes");
						if(aa0 != null) {toBeReturned.setInnings_B_1_batting_player_11_innings_1_sixes(clean(aa0.toString()));}
						JsonNode aa00 = inningsNode.get("1").get("batting").get("fours");
						if(aa00 != null) {toBeReturned.setInnings_B_1_batting_player_11_innings_1_fours(clean(aa00.toString()));}
						JsonNode aa01 = inningsNode.get("1").get("batting").get("balls");
						if(aa01 != null) {toBeReturned.setInnings_B_1_batting_player_11_innings_1_balls(clean(aa01.toString()));}
						JsonNode aa02 = inningsNode.get("1").get("batting").get("runs");
						if(aa02 != null) {toBeReturned.setInnings_B_1_batting_player_11_innings_1_runs(clean(aa02.toString()));}
						JsonNode aa1 = inningsNode.get("1").get("batting").get("out_str");
						if(aa1 != null) {toBeReturned.setInnings_B_1_batting_player_11_innings_1_out_comment(clean( aa1.toString()));}
						JsonNode aa3 = inningsNode.get("1").get("bowling").get("maiden_overs");
						if(aa3 != null) {toBeReturned.setInnings_B_1_bowling_player_11_innings_1_maiden_overs(clean( aa3.toString()));}

						JsonNode aa1xx = inningsNode.get("1").get("batting").get("strike_rate");
						if(aa1xx != null) {toBeReturned.setInnings_B_1_batting_player_11_innings_1_strike_rate(clean( aa1xx.toString()));}



						JsonNode secondInnings = inningsNode.get("2");
						if(secondInnings !=null) {
							JsonNode ab0 = inningsNode.get("2").get("batting").get("sixes");
							if (ab0 != null) {
								toBeReturned.setInnings_B_1_batting_player_11_innings_2_sixes(clean(ab0.toString()));
							}
							JsonNode ab00 = inningsNode.get("2").get("batting").get("fours");
							if (ab00 != null) {
								toBeReturned.setInnings_B_1_batting_player_11_innings_2_fours(clean(ab00.toString()));
							}
							JsonNode ab01 = inningsNode.get("2").get("batting").get("balls");
							if (ab01 != null) {
								toBeReturned.setInnings_B_1_batting_player_11_innings_2_balls(clean(ab01.toString()));
							}
							JsonNode ab02 = inningsNode.get("2").get("batting").get("runs");
							if (ab02 != null) {
								toBeReturned.setInnings_B_1_batting_player_11_innings_2_runs(clean(ab02.toString()));
							}
							JsonNode ab1 = inningsNode.get("2").get("batting").get("out_str");
							if (ab1 != null) {
								toBeReturned.setInnings_B_1_batting_player_11_innings_2_out_comment(clean(ab1.toString()));
							}
							JsonNode ab3 = inningsNode.get("2").get("bowling").get("maiden_overs");
							if (ab3 != null) {
								toBeReturned.setInnings_B_1_bowling_player_11_innings_2_maiden_overs(clean(ab3.toString()));
							}
							JsonNode aa2xx = inningsNode.get("2").get("batting").get("strike_rate");
							if(aa2xx != null) {toBeReturned.setInnings_B_1_batting_player_11_innings_2_strike_rate(clean( aa2xx.toString()));}

						}
					}

				}


			JsonNode players = card.get("teams").get("a").get("match").get("playing_xi");
				List<String> playersCasted = new ArrayList<>();

			if (players.isArray()) {
				for (final JsonNode objNode : players) {
					System.out.println(objNode);
					playersCasted.add(clean(objNode.toString()));
				}
			}
			List<String> toBeAdded = new ArrayList<>();

				if(size_A_1 < playersCasted.size()){

						for(int x=0; x < playersCasted.size(); x++){
							boolean flag = false;
							System.out.println("--------------initial get-------------");
							System.out.println(playersCasted.get(x));

							for(int o=0; o < toBeReturned.getInnings_A_1_batting_order().size(); o++){
								String keyInOrder = toBeReturned.getInnings_A_1_batting_order().get(o);
								System.out.println("->");
								System.out.println(keyInOrder);


								if(keyInOrder.contains(playersCasted.get(x))){
									System.out.println("inside if else check");
									flag = true;
								}
							}
							if(!flag){

								JsonNode playerNode = playersNode.get(playersCasted.get(x));
								if(playerNode !=null){
									toBeAdded.add(clean(playerNode.get("fullname").toString()));
								}

							}

						}

				}

				System.out.println("===================================>>>>>>>>>>>>>>>>>");
				for(int k=0;k < toBeAdded.size(); k++){
					System.out.println(toBeAdded.get(k));
				}

			System.out.println("=>>>>>>>>>>>>>>>>>");
				for(int xx = 0; xx< toBeAdded.size();xx++){
					System.out.println(xx+" -> "+ toBeAdded.get(xx));
					int y = toBeReturned.getInnings_A_1_batting_order().size()+xx;
					System.out.println("now to be added: -> " + y + " : " + toBeAdded.get(xx));
					if(y ==10) {
						toBeReturned.setInnings_A_1_batting_player_11_full_name(toBeAdded.get(xx));
					}else if(y ==9) {
						toBeReturned.setInnings_A_1_batting_player_10_full_name(toBeAdded.get(xx));
					}else if(y ==8) {
						toBeReturned.setInnings_A_1_batting_player_9_full_name(toBeAdded.get(xx));
					}else if(y ==7) {
						toBeReturned.setInnings_A_1_batting_player_8_full_name(toBeAdded.get(xx));
					}else if(y ==6) {
						toBeReturned.setInnings_A_1_batting_player_7_full_name(toBeAdded.get(xx));
					}else if(y ==5) {
						toBeReturned.setInnings_A_1_batting_player_6_full_name(toBeAdded.get(xx));
					}else if(y ==4) {
						toBeReturned.setInnings_A_1_batting_player_5_full_name(toBeAdded.get(xx));
					}else if(y ==3) {
						toBeReturned.setInnings_A_1_batting_player_4_full_name(toBeAdded.get(xx));
					}else if(y ==2) {
						toBeReturned.setInnings_A_1_batting_player_3_full_name(toBeAdded.get(xx));
					}else if(y ==1) {
						toBeReturned.setInnings_A_1_batting_player_2_full_name(toBeAdded.get(xx));
					}else if(y ==0) {
						toBeReturned.setInnings_A_1_batting_player_1_full_name(toBeAdded.get(xx));
					}
				}


				////for team b

			JsonNode playersb = card.get("teams").get("b").get("match").get("playing_xi");
			List<String> playersbCasted = new ArrayList<>();

			if (playersb.isArray()) {
				for (final JsonNode objNode : playersb) {
					//System.out.println(objNode);
					playersbCasted.add(clean(objNode.toString()));
				}
			}
			List<String> toBeAddedb = new ArrayList<>();

			if(size_B_1 < playersbCasted.size()){

				for(int x=0; x < playersbCasted.size(); x++){
					boolean flag = false;

					for(int o=0; o < toBeReturned.getInnings_B_1_batting_order().size(); o++){
						String keyInOrder = toBeReturned.getInnings_B_1_batting_order().get(o);
						if(keyInOrder.contains(playersbCasted.get(x))){
							flag = true;
						}
					}
					if(!flag){

						JsonNode playerNode = playersNode.get(playersbCasted.get(x));
						if(playerNode !=null) {
							toBeAddedb.add(clean(playerNode.get("fullname").toString()));
						}
					}

				}

			}
			for(int xx = 0; xx< toBeAddedb.size();xx++){
				System.out.println(xx+" -> "+ toBeAddedb.get(xx));
				int y = toBeReturned.getInnings_B_1_batting_order().size()+xx;
				System.out.println("now to be added: -> " + y + " : " + toBeAddedb.get(xx));
				if(y ==10) {
					toBeReturned.setInnings_B_1_batting_player_11_full_name(toBeAddedb.get(xx));
				}else if(y ==9) {
					toBeReturned.setInnings_B_1_batting_player_10_full_name(toBeAddedb.get(xx));
				}else if(y ==8) {
					toBeReturned.setInnings_B_1_batting_player_9_full_name(toBeAddedb.get(xx));
				}else if(y ==7) {
					toBeReturned.setInnings_B_1_batting_player_8_full_name(toBeAddedb.get(xx));
				}else if(y ==6) {
					toBeReturned.setInnings_B_1_batting_player_7_full_name(toBeAddedb.get(xx));
				}else if(y ==5) {
					toBeReturned.setInnings_B_1_batting_player_6_full_name(toBeAddedb.get(xx));
				}else if(y ==4) {
					toBeReturned.setInnings_B_1_batting_player_5_full_name(toBeAddedb.get(xx));
				}else if(y ==3) {
					toBeReturned.setInnings_B_1_batting_player_4_full_name(toBeAddedb.get(xx));
				}else if(y ==2) {
					toBeReturned.setInnings_B_1_batting_player_3_full_name(toBeAddedb.get(xx));
				}else if(y ==1) {
					toBeReturned.setInnings_B_1_batting_player_2_full_name(toBeAddedb.get(xx));
				}else if(y ==0) {
					toBeReturned.setInnings_B_1_batting_player_1_full_name(toBeAddedb.get(xx));
				}
			}


			//bowling nigga bowling!!!
			List<String> A_1_Bowling = c.getInnings().getA_1().getBowling_order();

			List<String> A_2_Bowling = new ArrayList<>();

			if(c.getInnings().getA_2() !=null){
				A_2_Bowling = c.getInnings().getA_2().getBowling_order();
			}

			List<String> B_1_Bowling = c.getInnings().getB_1().getBowling_order();
			List<String> B_2_Bowling = new ArrayList<>();

			if(c.getInnings().getB_2() !=null){
				B_2_Bowling = c.getInnings().getB_2().getBowling_order();
			}



			List<Bowling> toBeReturnedBowling_A_1 = new ArrayList<>();
			List<Bowling> toBeReturnedBowling_A_2 = new ArrayList<>();
			List<Bowling> toBeReturnedBowling_B_1 = new ArrayList<>();
			List<Bowling> toBeReturnedBowling_B_2 = new ArrayList<>();



			//A_1
			for(int i=0; i< A_1_Bowling.size();i++){
				JsonNode playerNode = playersNode.get(A_1_Bowling.get(i));
				JsonNode inningsNode = playerNode.get("match").get("innings");

				String playerName = clean(playerNode.get("fullname").toString());

				Bowling bowling = new Bowling();
				bowling.setFullName(playerName);

				JsonNode balls = inningsNode.get("1").get("bowling").get("balls");
				if(balls != null) {bowling.setBalls(clean(balls.toString()));}

				JsonNode maiden_overs = inningsNode.get("1").get("bowling").get("maiden_overs");
				if(maiden_overs != null) {bowling.setMaiden_overs(clean(maiden_overs.toString()));}

				JsonNode dots = inningsNode.get("1").get("bowling").get("dots");
				if(dots != null) {bowling.setDots(clean(dots.toString()));}

				JsonNode runs = inningsNode.get("1").get("bowling").get("runs");
				if(runs != null) {bowling.setRuns(clean(balls.toString()));}

				JsonNode overs = inningsNode.get("1").get("bowling").get("overs");
				if(overs != null) {bowling.setOvers(clean(overs.toString()));}

				JsonNode wickets = inningsNode.get("1").get("bowling").get("wickets");
				if(wickets != null) {bowling.setWickets(clean(wickets.toString()));}

				JsonNode extras = inningsNode.get("1").get("bowling").get("extras");
				if(extras != null) {bowling.setExtras(clean(extras.toString()));}

				JsonNode economy = inningsNode.get("1").get("bowling").get("economy");
				if(economy != null) {bowling.setEconomy(clean(economy.toString()));}

				toBeReturnedBowling_A_1.add(bowling);
			}

			//A_2
			for(int i=0; i< A_2_Bowling.size();i++){
				JsonNode playerNode = playersNode.get(A_2_Bowling.get(i));
				JsonNode inningsNode = playerNode.get("match").get("innings");

				String playerName = clean(playerNode.get("fullname").toString());

				Bowling bowling = new Bowling();
				bowling.setFullName(playerName);

				JsonNode balls = inningsNode.get("2").get("bowling").get("balls");
				if(balls != null) {bowling.setBalls(clean(balls.toString()));}

				JsonNode maiden_overs = inningsNode.get("2").get("bowling").get("maiden_overs");
				if(maiden_overs != null) {bowling.setMaiden_overs(clean(maiden_overs.toString()));}

				JsonNode dots = inningsNode.get("2").get("bowling").get("dots");
				if(dots != null) {bowling.setDots(clean(dots.toString()));}

				JsonNode runs = inningsNode.get("2").get("bowling").get("runs");
				if(runs != null) {bowling.setRuns(clean(balls.toString()));}

				JsonNode overs = inningsNode.get("2").get("bowling").get("overs");
				if(overs != null) {bowling.setOvers(clean(overs.toString()));}

				JsonNode wickets = inningsNode.get("2").get("bowling").get("wickets");
				if(wickets != null) {bowling.setWickets(clean(wickets.toString()));}

				JsonNode extras = inningsNode.get("2").get("bowling").get("extras");
				if(extras != null) {bowling.setExtras(clean(extras.toString()));}

				JsonNode economy = inningsNode.get("2").get("bowling").get("economy");
				if(economy != null) {bowling.setEconomy(clean(economy.toString()));}

				toBeReturnedBowling_A_2.add(bowling);
			}

			//B_1
			for(int i=0; i< B_1_Bowling.size();i++){

				System.out.println("bowling order print-> " + B_1_Bowling.get(i));


				JsonNode playerNode = playersNode.get(B_1_Bowling.get(i));
				JsonNode inningsNode = playerNode.get("match").get("innings");

				String playerName = clean(playerNode.get("fullname").toString());

				System.out.println(playersNode.toString());

				Bowling bowling = new Bowling();
				bowling.setFullName(playerName);

				JsonNode balls = inningsNode.get("1").get("bowling").get("balls");
				if(balls != null) {bowling.setBalls(clean(balls.toString()));}

				JsonNode maiden_overs = inningsNode.get("1").get("bowling").get("maiden_overs");
				if(maiden_overs != null) {bowling.setMaiden_overs(clean(maiden_overs.toString()));}

				JsonNode dots = inningsNode.get("1").get("bowling").get("dots");
				if(dots != null) {bowling.setDots(clean(dots.toString()));}

				JsonNode runs = inningsNode.get("1").get("bowling").get("runs");
				if(runs != null) {bowling.setRuns(clean(balls.toString()));}

				JsonNode overs = inningsNode.get("1").get("bowling").get("overs");
				if(overs != null) {bowling.setOvers(clean(overs.toString()));}

				JsonNode wickets = inningsNode.get("1").get("bowling").get("wickets");
				if(wickets != null) {bowling.setWickets(clean(wickets.toString()));}

				JsonNode extras = inningsNode.get("1").get("bowling").get("extras");
				if(extras != null) {bowling.setExtras(clean(extras.toString()));}

				JsonNode economy = inningsNode.get("1").get("bowling").get("economy");
				if(economy != null) {bowling.setEconomy(clean(economy.toString()));}

				toBeReturnedBowling_B_1.add(bowling);
			}
			//B_2
			for(int i=0; i< B_2_Bowling.size();i++){
				JsonNode playerNode = playersNode.get(B_2_Bowling.get(i));
				JsonNode inningsNode = playerNode.get("match").get("innings");

				String playerName = clean(playerNode.get("fullname").toString());

				Bowling bowling = new Bowling();
				bowling.setFullName(playerName);

				JsonNode balls = inningsNode.get("2").get("bowling").get("balls");
				if(balls != null) {bowling.setBalls(clean(balls.toString()));}

				JsonNode maiden_overs = inningsNode.get("2").get("bowling").get("maiden_overs");
				if(maiden_overs != null) {bowling.setMaiden_overs(clean(maiden_overs.toString()));}

				JsonNode dots = inningsNode.get("2").get("bowling").get("dots");
				if(dots != null) {bowling.setDots(clean(dots.toString()));}

				JsonNode runs = inningsNode.get("2").get("bowling").get("runs");
				if(runs != null) {bowling.setRuns(clean(balls.toString()));}

				JsonNode overs = inningsNode.get("2").get("bowling").get("overs");
				if(overs != null) {bowling.setOvers(clean(overs.toString()));}

				JsonNode wickets = inningsNode.get("2").get("bowling").get("wickets");
				if(wickets != null) {bowling.setWickets(clean(wickets.toString()));}

				JsonNode extras = inningsNode.get("2").get("bowling").get("extras");
				if(extras != null) {bowling.setExtras(clean(extras.toString()));}

				JsonNode economy = inningsNode.get("2").get("bowling").get("economy");
				if(economy != null) {bowling.setEconomy(clean(economy.toString()));}

				toBeReturnedBowling_B_2.add(bowling);
			}



//			toBeReturned.setBowling_a_1(toBeReturnedBowling_A_1);
//			toBeReturned.setBowling_b_1(toBeReturnedBowling_B_1);
//			toBeReturned.setBowling_a_2(toBeReturnedBowling_A_2);
//			toBeReturned.setBowling_b_2(toBeReturnedBowling_B_2);

//never use react
//a_1 bowling
			for(int i =0 ; i < toBeReturnedBowling_A_1.size(); i ++){
				Bowling bowling = toBeReturnedBowling_A_1.get(i);
				if(i==0){
					toBeReturned.setBowling_a_1_player_1_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_1_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_1_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_1_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_1_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_1_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_1_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_1_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_1_name(bowling.getFullName());

				}else if(i==1){
					toBeReturned.setBowling_a_1_player_2_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_2_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_2_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_2_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_2_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_2_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_2_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_2_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_2_name(bowling.getFullName());
				}else if(i==2){
					toBeReturned.setBowling_a_1_player_3_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_3_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_3_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_3_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_3_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_3_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_3_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_3_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_3_name(bowling.getFullName());
				}else if(i==3){
					toBeReturned.setBowling_a_1_player_4_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_4_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_4_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_4_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_4_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_4_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_4_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_4_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_4_name(bowling.getFullName());
				}else if(i==4){
					toBeReturned.setBowling_a_1_player_5_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_5_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_5_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_5_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_5_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_5_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_5_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_5_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_5_name(bowling.getFullName());
				}else if(i==5){
					toBeReturned.setBowling_a_1_player_6_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_6_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_6_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_6_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_6_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_6_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_6_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_6_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_6_name(bowling.getFullName());
				}else if(i==6){
					toBeReturned.setBowling_a_1_player_7_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_7_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_7_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_7_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_7_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_7_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_7_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_7_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_7_name(bowling.getFullName());
				}else if(i==7){
					toBeReturned.setBowling_a_1_player_8_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_8_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_8_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_8_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_8_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_8_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_8_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_8_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_8_name(bowling.getFullName());
				}else if(i==8){
					toBeReturned.setBowling_a_1_player_9_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_9_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_9_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_9_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_9_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_9_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_9_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_9_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_9_name(bowling.getFullName());
				}else if(i==9){
					toBeReturned.setBowling_a_1_player_10_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_10_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_10_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_10_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_10_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_10_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_10_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_10_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_10_name(bowling.getFullName());
				}else if(i==10){
					toBeReturned.setBowling_a_1_player_11_balls(bowling.getBalls());
					toBeReturned.setBowling_a_1_player_11_dots(bowling.getDots());
					toBeReturned.setBowling_a_1_player_11_runs(bowling.getRuns());
					toBeReturned.setBowling_a_1_player_11_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_1_player_11_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_1_player_11_extras(bowling.getExtras());
					toBeReturned.setBowling_a_1_player_11_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_1_player_11_overs(bowling.getOvers());
					toBeReturned.setBowling_a_1_player_11_name(bowling.getFullName());
				}
			}

			//a_2 bowling
			for(int i =0 ; i < toBeReturnedBowling_A_2.size(); i ++){
				Bowling bowling = toBeReturnedBowling_A_2.get(i);
				if(i==0){
					toBeReturned.setBowling_a_2_player_1_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_1_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_1_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_1_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_1_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_1_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_1_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_1_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_1_name(bowling.getFullName());

				}else if(i==1){
					toBeReturned.setBowling_a_2_player_2_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_2_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_2_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_2_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_2_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_2_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_2_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_2_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_2_name(bowling.getFullName());
				}else if(i==2){
					toBeReturned.setBowling_a_2_player_3_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_3_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_3_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_3_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_3_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_3_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_3_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_3_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_3_name(bowling.getFullName());
				}else if(i==3){
					toBeReturned.setBowling_a_2_player_4_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_4_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_4_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_4_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_4_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_4_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_4_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_4_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_4_name(bowling.getFullName());
				}else if(i==4){
					toBeReturned.setBowling_a_2_player_5_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_5_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_5_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_5_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_5_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_5_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_5_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_5_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_5_name(bowling.getFullName());
				}else if(i==5){
					toBeReturned.setBowling_a_2_player_6_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_6_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_6_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_6_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_6_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_6_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_6_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_6_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_6_name(bowling.getFullName());
				}else if(i==6){
					toBeReturned.setBowling_a_2_player_7_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_7_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_7_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_7_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_7_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_7_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_7_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_7_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_7_name(bowling.getFullName());
				}else if(i==7){
					toBeReturned.setBowling_a_2_player_8_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_8_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_8_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_8_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_8_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_8_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_8_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_8_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_8_name(bowling.getFullName());
				}else if(i==8){
					toBeReturned.setBowling_a_2_player_9_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_9_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_9_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_9_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_9_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_9_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_9_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_9_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_9_name(bowling.getFullName());
				}else if(i==9){
					toBeReturned.setBowling_a_2_player_10_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_10_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_10_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_10_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_10_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_10_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_10_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_10_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_10_name(bowling.getFullName());
				}else if(i==10){
					toBeReturned.setBowling_a_2_player_11_balls(bowling.getBalls());
					toBeReturned.setBowling_a_2_player_11_dots(bowling.getDots());
					toBeReturned.setBowling_a_2_player_11_runs(bowling.getRuns());
					toBeReturned.setBowling_a_2_player_11_economy(bowling.getEconomy());
					toBeReturned.setBowling_a_2_player_11_wickets(bowling.getWickets());
					toBeReturned.setBowling_a_2_player_11_extras(bowling.getExtras());
					toBeReturned.setBowling_a_2_player_11_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_a_2_player_11_overs(bowling.getOvers());
					toBeReturned.setBowling_a_2_player_11_name(bowling.getFullName());
				}
			}

			//b_1 bowling
			for(int i =0 ; i < toBeReturnedBowling_B_1.size(); i ++){
				Bowling bowling = toBeReturnedBowling_B_1.get(i);
				if(i==0){
					toBeReturned.setBowling_b_1_player_1_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_1_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_1_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_1_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_1_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_1_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_1_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_1_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_1_name(bowling.getFullName());

				}else if(i==1){
					toBeReturned.setBowling_b_1_player_2_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_2_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_2_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_2_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_2_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_2_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_2_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_2_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_2_name(bowling.getFullName());
				}else if(i==2){
					toBeReturned.setBowling_b_1_player_3_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_3_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_3_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_3_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_3_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_3_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_3_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_3_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_3_name(bowling.getFullName());
				}else if(i==3){
					toBeReturned.setBowling_b_1_player_4_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_4_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_4_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_4_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_4_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_4_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_4_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_4_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_4_name(bowling.getFullName());
				}else if(i==4){
					toBeReturned.setBowling_b_1_player_5_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_5_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_5_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_5_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_5_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_5_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_5_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_5_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_5_name(bowling.getFullName());
				}else if(i==5){
					toBeReturned.setBowling_b_1_player_6_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_6_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_6_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_6_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_6_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_6_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_6_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_6_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_6_name(bowling.getFullName());
				}else if(i==6){
					toBeReturned.setBowling_b_1_player_7_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_7_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_7_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_7_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_7_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_7_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_7_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_7_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_7_name(bowling.getFullName());
				}else if(i==7){
					toBeReturned.setBowling_b_1_player_8_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_8_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_8_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_8_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_8_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_8_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_8_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_8_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_8_name(bowling.getFullName());
				}else if(i==8){
					toBeReturned.setBowling_b_1_player_9_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_9_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_9_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_9_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_9_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_9_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_9_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_9_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_9_name(bowling.getFullName());
				}else if(i==9){
					toBeReturned.setBowling_b_1_player_10_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_10_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_10_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_10_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_10_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_10_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_10_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_10_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_10_name(bowling.getFullName());
				}else if(i==10){
					toBeReturned.setBowling_b_1_player_11_balls(bowling.getBalls());
					toBeReturned.setBowling_b_1_player_11_dots(bowling.getDots());
					toBeReturned.setBowling_b_1_player_11_runs(bowling.getRuns());
					toBeReturned.setBowling_b_1_player_11_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_1_player_11_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_1_player_11_extras(bowling.getExtras());
					toBeReturned.setBowling_b_1_player_11_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_1_player_11_overs(bowling.getOvers());
					toBeReturned.setBowling_b_1_player_11_name(bowling.getFullName());
				}
			}

			//b_2 bowling
			for(int i =0 ; i < toBeReturnedBowling_B_2.size(); i ++){
				Bowling bowling = toBeReturnedBowling_B_2.get(i);
				if(i==0){
					toBeReturned.setBowling_b_2_player_1_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_1_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_1_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_1_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_1_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_1_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_1_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_1_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_1_name(bowling.getFullName());

				}else if(i==1){
					toBeReturned.setBowling_b_2_player_2_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_2_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_2_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_2_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_2_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_2_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_2_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_2_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_2_name(bowling.getFullName());
				}else if(i==2){
					toBeReturned.setBowling_b_2_player_3_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_3_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_3_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_3_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_3_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_3_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_3_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_3_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_3_name(bowling.getFullName());
				}else if(i==3){
					toBeReturned.setBowling_b_2_player_4_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_4_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_4_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_4_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_4_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_4_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_4_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_4_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_4_name(bowling.getFullName());
				}else if(i==4){
					toBeReturned.setBowling_b_2_player_5_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_5_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_5_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_5_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_5_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_5_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_5_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_5_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_5_name(bowling.getFullName());
				}else if(i==5){
					toBeReturned.setBowling_b_2_player_6_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_6_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_6_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_6_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_6_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_6_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_6_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_6_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_6_name(bowling.getFullName());
				}else if(i==6){
					toBeReturned.setBowling_b_2_player_7_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_7_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_7_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_7_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_7_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_7_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_7_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_7_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_7_name(bowling.getFullName());
				}else if(i==7){
					toBeReturned.setBowling_b_2_player_8_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_8_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_8_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_8_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_8_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_8_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_8_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_8_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_8_name(bowling.getFullName());
				}else if(i==8){
					toBeReturned.setBowling_b_2_player_9_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_9_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_9_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_9_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_9_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_9_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_9_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_9_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_9_name(bowling.getFullName());
				}else if(i==9){
					toBeReturned.setBowling_b_2_player_10_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_10_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_10_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_10_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_10_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_10_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_10_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_10_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_10_name(bowling.getFullName());
				}else if(i==10){
					toBeReturned.setBowling_b_2_player_11_balls(bowling.getBalls());
					toBeReturned.setBowling_b_2_player_11_dots(bowling.getDots());
					toBeReturned.setBowling_b_2_player_11_runs(bowling.getRuns());
					toBeReturned.setBowling_b_2_player_11_economy(bowling.getEconomy());
					toBeReturned.setBowling_b_2_player_11_wickets(bowling.getWickets());
					toBeReturned.setBowling_b_2_player_11_extras(bowling.getExtras());
					toBeReturned.setBowling_b_2_player_11_maiden_overs(bowling.getMaiden_overs());
					toBeReturned.setBowling_b_2_player_11_overs(bowling.getOvers());
					toBeReturned.setBowling_b_2_player_11_name(bowling.getFullName());
				}
			}

//			toBeReturned.setBowling_b_1(toBeReturnedBowling_B_1);
//			toBeReturned.setBowling_a_2(toBeReturnedBowling_A_2);
//			toBeReturned.setBowling_b_2(toBeReturnedBowling_B_2);

			JsonNode now = card.get("now");
			String player_1, player_2;

			if(now !=null
					&& now.get("last_ball")!=null
					&& now.get("last_ball").get("striker")!=null
					&& now.get("last_ball").get("nonstriker")!=null) {

				player_1 = clean(now.get("last_ball").get("striker").toString());
				player_2 = clean(now.get("last_ball").get("nonstriker").toString());

				JsonNode playerNode1 = playersNode.get(player_1);
				JsonNode playerNode2 = playersNode.get(player_2);
				JsonNode inningsNode1 = playerNode1.get("match").get("innings");
				JsonNode inningsNode2 = playerNode2.get("match").get("innings");



				toBeReturned.setLatest_batsman_1_name(clean(playerNode1.get("fullname").toString()));
				JsonNode aa0 = inningsNode1.get("1").get("batting").get("sixes");
				if(aa0 != null) {toBeReturned.setLatest_batsman_1_sixes(clean(aa0.toString()));}
				JsonNode aa00 = inningsNode1.get("1").get("batting").get("fours");
				if(aa00 != null) {toBeReturned.setLatest_batsman_1_fours(clean(aa00.toString()));}
				JsonNode aa01 = inningsNode1.get("1").get("batting").get("balls");
				if(aa01 != null) {toBeReturned.setLatest_batsman_1_balls(clean(aa01.toString()));}
				JsonNode aa02 = inningsNode1.get("1").get("batting").get("runs");
				if(aa02 != null) {toBeReturned.setLatest_batsman_1_runs(clean(aa02.toString()));}

				JsonNode aa3 = inningsNode1.get("1").get("bowling").get("overs");
				if(aa3 != null) {toBeReturned.setLatest_batsman_1_overs(clean( aa3.toString()));}

				JsonNode aa1xx = inningsNode1.get("1").get("batting").get("strike_rate");
				if(aa1xx != null) {toBeReturned.setLatest_batsman_1_strike_rate(clean( aa1xx.toString()));}


				toBeReturned.setLatest_batsman_2_name(clean(playerNode2.get("fullname").toString()));
				JsonNode aa021 = inningsNode2.get("1").get("batting").get("sixes");
				if(aa021 != null) {toBeReturned.setLatest_batsman_2_sixes(clean(aa021.toString()));}
				JsonNode aa100 = inningsNode2.get("1").get("batting").get("fours");
				if(aa100 != null) {toBeReturned.setLatest_batsman_2_fours(clean(aa100.toString()));}
				JsonNode aa011 = inningsNode2.get("1").get("batting").get("balls");
				if(aa011 != null) {toBeReturned.setLatest_batsman_2_balls(clean(aa011.toString()));}
				JsonNode aa012 = inningsNode2.get("1").get("batting").get("runs");
				if(aa012 != null) {toBeReturned.setLatest_batsman_2_runs(clean(aa012.toString()));}

				JsonNode aa13 = inningsNode2.get("1").get("bowling").get("overs");
				if(aa13 != null) {toBeReturned.setLatest_batsman_2_overs(clean( aa13.toString()));}

				JsonNode aa11xx = inningsNode2.get("1").get("batting").get("strike_rate");
				if(aa11xx != null) {toBeReturned.setLatest_batsman_2_strike_rate(clean( aa11xx.toString()));}

				JsonNode bowler = now.get("last_ball").get("bowler");
//
//				JsonNode runss = bowler.get("runs");
//				if(runss != null) {toBeReturned.setLatest_bowler_runs(clean( runss.toString()));}
//
//				JsonNode bowler_extras = bowler.get("extras");
//				if(bowler_extras != null) {toBeReturned.setLatest_bowler_extras(clean( bowler_extras.toString()));}
//
//				JsonNode ballCount = bowler.get("ball_count");
//				if(ballCount != null) {toBeReturned.setLatest_bowler_ball_count(clean( ballCount.toString()));}
//
//				JsonNode wicket = bowler.get("wicket");
//				if(wicket != null) {toBeReturned.setLatest_bowler_wicket(clean( wicket.toString()));}
//
//				JsonNode bowlerKey = bowler.get("key");
//				if(bowlerKey != null) {
//
//					toBeReturned.setLatest_bowler_name(clean( players.get(clean(bowlerKey.toString())).get("fullname").toString()));
//
//					toBeReturned.setLatest_bowler_wicket(clean( wicket.toString()));
//
//				}
				JsonNode comment = now.get("last_ball").get("comment");
				if(comment != null) {toBeReturned.setLatest_bowler_comment(html2text(clean( comment.toString())));}else {System.out.println("comment null");}

			}
			String manOfMatchKey = c.getMan_of_match();

			JsonNode pla = players.get(clean(manOfMatchKey));

			if(pla != null){
				String manOfMatchFullName = players.get(clean(manOfMatchKey)).get("fullname").toString();
				toBeReturned.setMan_of_match(manOfMatchFullName);
			}else{
				toBeReturned.setMan_of_match(manOfMatchKey);
			}


			return toBeReturned;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<CardCustomForOniHome> getLiveMatchesShortCard() {
		Request request = new Request.Builder()
				.url(HttpUrl.parse(recentMatchUrl).newBuilder().addQueryParameter("access_token", getAccessToken())
						.addQueryParameter("card_type", "summary_card").toString())
				.get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo yo = new ObjectMapper().readValue(response.body().bytes(), Yo.class);
			List<Card> receivedCards = yo.getData().getCards();

			List<Card> tr = receivedCards.stream().filter(t -> t.getStatus().equals("started"))
					.collect(Collectors.toList());

			List<CardCustomForOniHome> toBeReturnedList = new ArrayList<CardCustomForOniHome>();
			for (int i = 0; i < tr.size(); i++) {
				Card c = tr.get(i);

				// getMatchSummary(c.getKey()).getNow().getR;

				String[] a = c.getShort_name().split("vs");
				c.setTeam_a(a[0].replaceAll("\\s+", ""));
				c.setTeam_b(a[1].replaceAll("\\s+", ""));

				c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
				c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));
				
				CardCustomForOniHome toBeReturned = new CardCustomForOniHome();

				toBeReturned.setTeam_a(c.getTeam_a());
				toBeReturned.setTeam_b(c.getTeam_b());
				toBeReturned.setTeam_a_url(c.getTeam_a_url());
				toBeReturned.setTeam_b_url(c.getTeam_b_url());
				toBeReturned.setRelated_name(c.getRelated_name());
				toBeReturned.setMsgs_result(c.getMsgs().getResult());
				toBeReturned.setMsgs_others(c.getMsgs().getOthers());
				toBeReturned.setToss_decision(c.getToss().getDecision());
				toBeReturned.setToss_str(c.getToss().getStr());
				toBeReturned.setToss_won(c.getToss().getWon());
				toBeReturned.setWinner_team(c.getWinner_team());

				
				toBeReturned.setInnings_A_1_runs(c.getInnings().getA_1().getRuns());
				toBeReturned.setInnings_A_1_balls(c.getInnings().getA_1().getBalls());
				toBeReturned.setInnings_A_1_wickets(c.getInnings().getA_1().getWickets());
				toBeReturned.setInnings_A_1_overs(c.getInnings().getA_1().getOvers());
				
				
				toBeReturned.setInnings_B_1_runs(c.getInnings().getB_1().getRuns());
				toBeReturned.setInnings_B_1_balls(c.getInnings().getB_1().getBalls());
				toBeReturned.setInnings_B_1_wickets(c.getInnings().getB_1().getWickets());
				toBeReturned.setInnings_B_1_overs(c.getInnings().getB_1().getOvers());
				

				toBeReturned.setDl_applied(c.getDl_applied());
				toBeReturned.setStatus(c.getStatus());
				toBeReturned.setMan_of_match(c.getMan_of_match());
				toBeReturned.setDescription(c.getDescription());
				toBeReturned.setShort_name(c.getShort_name());
				toBeReturned.setFormat(c.getFormat());
				toBeReturned.setKey(c.getKey());
				toBeReturned.setDay(c.getDay());
				toBeReturned.setVenue(c.getVenue());
				toBeReturned.setName(c.getName());
				toBeReturned.setStart_date_iso(c.getStart_date().getIso());
				toBeReturned.setStart_date_str(c.getStart_date().getStr());
				toBeReturned.setStart_date_timestamp(c.getStart_date().getTimestamp());
				toBeReturnedList.add(toBeReturned);
			}

			return toBeReturnedList;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public CustomOniObjectForShortCard getRecentMatchesShortCard() {
		Request request = new Request.Builder()
				.url(HttpUrl.parse(recentMatchUrl).newBuilder().addQueryParameter("access_token", getAccessToken())
						.addQueryParameter("card_type", "summary_card").toString())
				.get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo yo = new ObjectMapper().readValue(response.body().bytes(), Yo.class);
			List<Card> receivedCards = yo.getData().getCards();

			List<Card> tr = receivedCards.stream().filter(t -> t.getStatus().equals("completed"))
					.collect(Collectors.toList());

			List<CardCustomForOniHome> toBeReturnedList = new ArrayList<CardCustomForOniHome>();
			for (int i = 0; i < tr.size(); i++) {
				Card c = tr.get(i);

				// getMatchSummary(c.getKey()).getNow().getR;

				String[] a = c.getShort_name().split("vs");
				c.setTeam_a(a[0].replaceAll("\\s+", ""));
				c.setTeam_b(a[1].replaceAll("\\s+", ""));

				c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
				c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));
				
				CardCustomForOniHome toBeReturned = new CardCustomForOniHome();

				toBeReturned.setTeam_a(c.getTeam_a());
				toBeReturned.setTeam_b(c.getTeam_b());
				toBeReturned.setTeam_a_url(c.getTeam_a_url());
				toBeReturned.setTeam_b_url(c.getTeam_b_url());
				toBeReturned.setRelated_name(c.getRelated_name());
				toBeReturned.setMsgs_result(c.getMsgs().getResult());
				toBeReturned.setMsgs_others(c.getMsgs().getOthers());
				toBeReturned.setToss_decision(c.getToss().getDecision());
				toBeReturned.setToss_str(c.getToss().getStr());
				toBeReturned.setToss_won(c.getToss().getWon());
				toBeReturned.setWinner_team(c.getWinner_team());

				
				toBeReturned.setInnings_A_1_runs(c.getInnings().getA_1().getRuns());
				toBeReturned.setInnings_A_1_balls(c.getInnings().getA_1().getBalls());
				toBeReturned.setInnings_A_1_wickets(c.getInnings().getA_1().getWickets());
				toBeReturned.setInnings_A_1_overs(c.getInnings().getA_1().getOvers());
				
				
				toBeReturned.setInnings_B_1_runs(c.getInnings().getB_1().getRuns());
				toBeReturned.setInnings_B_1_balls(c.getInnings().getB_1().getBalls());
				toBeReturned.setInnings_B_1_wickets(c.getInnings().getB_1().getWickets());
				toBeReturned.setInnings_B_1_overs(c.getInnings().getB_1().getOvers());
				

				toBeReturned.setDl_applied(c.getDl_applied());
				toBeReturned.setStatus(c.getStatus());
				toBeReturned.setMan_of_match(c.getMan_of_match());
				toBeReturned.setDescription(c.getDescription());
				toBeReturned.setShort_name(c.getShort_name());
				toBeReturned.setFormat(c.getFormat());
				toBeReturned.setKey(c.getKey());
				toBeReturned.setDay(c.getDay());
				toBeReturned.setVenue(c.getVenue());
				toBeReturned.setName(c.getName());
				toBeReturned.setStart_date_iso(c.getStart_date().getIso());
				toBeReturned.setStart_date_str(c.getStart_date().getStr());
				toBeReturned.setStart_date_timestamp(c.getStart_date().getTimestamp());
				toBeReturnedList.add(toBeReturned);
			}

			CustomOniObjectForShortCard c = new CustomOniObjectForShortCard();
			c.setData(toBeReturnedList);
			return c;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<CardCustomForOniHome> getUpcomingMatchesShortCard() {
		Request request = new Request.Builder()
				.url(HttpUrl.parse(recentMatchUrl).newBuilder().addQueryParameter("access_token", getAccessToken())
						.addQueryParameter("card_type", "summary_card").toString())
				.get().build();

		System.out.println(request.toString());

		Response response;
		try {
			response = client.newCall(request).execute();
			Yo yo = new ObjectMapper().readValue(response.body().bytes(), Yo.class);
			List<Card> receivedCards = yo.getData().getCards();

			List<Card> tr = receivedCards.stream().filter(t -> t.getStatus().equals("notstarted"))
					.collect(Collectors.toList());

			List<CardCustomForOniHome> toBeReturnedList = new ArrayList<CardCustomForOniHome>();
			for (int i = 0; i < tr.size(); i++) {
				Card c = tr.get(i);

				// getMatchSummary(c.getKey()).getNow().getR;

				String[] a = c.getShort_name().split("vs");
				c.setTeam_a(a[0].replaceAll("\\s+", ""));
				c.setTeam_b(a[1].replaceAll("\\s+", ""));

				c.setTeam_a_url(((flagRepository.findByShortCode(c.getTeam_a()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_a()).getUrl()));
				c.setTeam_b_url(((flagRepository.findByShortCode(c.getTeam_b()) == null) ? "N/A"
						: flagRepository.findByShortCode(c.getTeam_b()).getUrl()));
				
				CardCustomForOniHome toBeReturned = new CardCustomForOniHome();

				toBeReturned.setTeam_a(c.getTeam_a());
				toBeReturned.setTeam_b(c.getTeam_b());
				toBeReturned.setTeam_a_url(c.getTeam_a_url());
				toBeReturned.setTeam_b_url(c.getTeam_b_url());
				toBeReturned.setRelated_name(c.getRelated_name());
				toBeReturned.setMsgs_result(c.getMsgs().getResult());
				toBeReturned.setMsgs_others(c.getMsgs().getOthers());
				toBeReturned.setToss_decision(c.getToss().getDecision());
				toBeReturned.setToss_str(c.getToss().getStr());
				toBeReturned.setToss_won(c.getToss().getWon());
				toBeReturned.setWinner_team(c.getWinner_team());

				
				toBeReturned.setInnings_A_1_runs(c.getInnings().getA_1().getRuns());
				toBeReturned.setInnings_A_1_balls(c.getInnings().getA_1().getBalls());
				toBeReturned.setInnings_A_1_wickets(c.getInnings().getA_1().getWickets());
				toBeReturned.setInnings_A_1_overs(c.getInnings().getA_1().getOvers());
				
				
				toBeReturned.setInnings_B_1_runs(c.getInnings().getB_1().getRuns());
				toBeReturned.setInnings_B_1_balls(c.getInnings().getB_1().getBalls());
				toBeReturned.setInnings_B_1_wickets(c.getInnings().getB_1().getWickets());
				toBeReturned.setInnings_B_1_overs(c.getInnings().getB_1().getOvers());
				

				toBeReturned.setDl_applied(c.getDl_applied());
				toBeReturned.setStatus(c.getStatus());
				toBeReturned.setMan_of_match(c.getMan_of_match());
				toBeReturned.setDescription(c.getDescription());
				toBeReturned.setShort_name(c.getShort_name());
				toBeReturned.setFormat(c.getFormat());
				toBeReturned.setKey(c.getKey());
				toBeReturned.setDay(c.getDay());
				toBeReturned.setVenue(c.getVenue());
				toBeReturned.setName(c.getName());
				toBeReturned.setStart_date_iso(c.getStart_date().getIso());
				toBeReturned.setStart_date_str(c.getStart_date().getStr());
				toBeReturned.setStart_date_timestamp(c.getStart_date().getTimestamp());
				toBeReturnedList.add(toBeReturned);
			}

			return toBeReturnedList;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	private String clean (String to) {
		
		if(to == null || to.equals("")) {
			return to;
		}else {
			return to.replaceAll("\\\"", "");
		}
	}
	
	public static String html2text(String html) {
	    return Jsoup.parse(html).text();
	}
}
