package com.vince.one.test;

import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.vince.one.model.AuthTokenInfo;

public class RestClient {
	
	public static final String REST_URL="http://localhost:8080/oneDev";
	
	public static final String REST_SERVICE_OAUTH_URL = "http://localhost:8080/oneDev/oauth/token";

	public static final String USERNAME_PASSWORD_GRANT = "?grant_type=password&client_id=client_vince_id&client_secret=secret";

	public static final String ACCESS_TOKEN_URL = "http://localhost:8080/oneDev/test/user_vince?access_token=";

	
	//Send a request  to get  authentication  by  username and password
	private static AuthTokenInfo getGrantedToken(String userName,String password) {
		RestTemplate restTemplate = new RestTemplate();
		AuthTokenInfo authTokenInfo = restTemplate.getForObject(REST_SERVICE_OAUTH_URL + USERNAME_PASSWORD_GRANT+"&username="+userName+"&password="+password,
				AuthTokenInfo.class);
		return authTokenInfo;
	}

	// get resource by making request to controller, using access_token
	private static Object retriveUserByAccessToken(String accessToken) {

		RestTemplate restTemplate = new RestTemplate();
		// set httpheaders
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + accessToken);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Object result = restTemplate.exchange(ACCESS_TOKEN_URL + accessToken, HttpMethod.GET, entity, Object.class);

		return result;
	}

	public static void main(String args[]) {
		
		// make direct request to the controller, but it won't work
		//http://localhost:8080/oneDev/user_vince

		
		// get token object by userName and password
		AuthTokenInfo tokenObject =  getGrantedToken("user_vince","password");
		System.out.println("The granted return obejct:"+tokenObject);
		
		// get access_token
		String accessToken = tokenObject.getAccess_token();
		// get protected resource by accessToken
		Object returnObject = retriveUserByAccessToken(accessToken);

		System.out.println("The result of request :"+ returnObject);

	}
}