package com.sweetitech.tiger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sweetitech.tiger.config.Constants;
import com.sweetitech.tiger.model.Image;
import com.sweetitech.tiger.model.Promotion;
import com.sweetitech.tiger.repository.PromotionRepository;
import com.sweetitech.tiger.service.interfaces.IPromotionService;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
@Transactional
public class PromotionService implements IPromotionService {

//	@Value("${firebase.server.token}")
	private static  String FIREBASE_SERVER_KEY ="AAAAjOGixYQ:APA91bEe0LE2FpxppHFXjYoX15VgN5Cx_D8bl7WrbCOZ9np33uCIelL8Q6M82CoU8PgIC0GWmd5FVCZvVCEw6s6TwoPm8kziKFR83u2IHfM6QUIKOGPk_g7Jmy4Bl434AR_CJjm24yL_EKz4qfRzlxCquQMFSs6mUw";


	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";


	@Autowired
	PromotionRepository promotionRepository;


	
	@Override
	public Page<Promotion> findAllPromotion(int page) {
		
		PageRequest request =
	            new PageRequest(page, Constants.PAGE_SIZE, Sort.Direction.DESC, "id");
		
	        return promotionRepository.findAll(request);
	}
	
	@Override
	public Promotion addPromotion(Promotion promotion) {

		return promotionRepository.save(promotion);

	}
	
	@Override
	public Promotion findById(Long id) {
		
		return promotionRepository.findById(id);
	}



	@Override
	public Promotion updatePromotion(Promotion promotion) {
		
		return promotionRepository.save(promotion);
	}

	@Override
	public String sendPromotionNotification(Promotion promotion) {

		if(promotion != null){
			try{
				return sendPush(promotion.getTitle(), promotion.getContent(), promotion.getLandingUrl(), promotion.getImage());
			}catch (Exception e){
				return "error";
			}
		}
		return "error";

	}




	@Override
	public void deletePromotion(Promotion promotion) {
		promotionRepository.delete(promotion);
	}


	private String sendPush(String title, String content, String landingUrl, Image image) throws JSONException {

		OkHttpClient client = new OkHttpClient();
		final MediaType JSON
				= MediaType.parse("application/json; charset=utf-8");

		String TOPIC = "all";

		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + TOPIC);
		body.put("priority", "high");

		JSONObject notification = new JSONObject();
		notification.put("title", title);
		notification.put("body", content);

		JSONObject data = new JSONObject();
		data.put("title", title);
		data.put("content", content);
		data.put("landingUrl", landingUrl);
		data.put("image", image.getUrl());

		body.put("notification", notification);
		body.put("data", data);


		System.out.println(body.toString());

		RequestBody bodyR = RequestBody.create(JSON, body.toString());


		//System.out.println(bodyR.);

		Request request = new Request.Builder()
				.url(HttpUrl.parse(FIREBASE_API_URL).newBuilder().toString())
				.post(bodyR)
				.addHeader("Authorization", "key=" + FIREBASE_SERVER_KEY)
				.addHeader("Content-Type", "application/json").build();

	//	System.out.println(request.headers());

		try {
			Response response = client.newCall(request).execute();

			return "Response Code: " + response.code() + ", Response Message: "+ response.message() + ", Body: "+ response.body().string();


		} catch (IOException e) {
			System.out.println(e.getMessage());
			return "Error";
		}

	}


}
