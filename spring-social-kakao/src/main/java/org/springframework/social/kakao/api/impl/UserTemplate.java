package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.AccessTokenInfo;
import org.springframework.social.kakao.api.KakaoIds;
import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.social.kakao.api.UserOperation;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractKakaoOperations implements UserOperation {
	
	private final RestTemplate restTemplate;
	private final RestTemplate adminRestTemplate;
	
	public UserTemplate(RestTemplate restTemplate, RestTemplate adminRestTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
		this.adminRestTemplate = adminRestTemplate;
	}
	
	@Override
	public long getProfileId() {
		requireAuthorization();
		return getUserProfile().getId();
	}
	
	@Override
	public String getNickname() {
		requireAuthorization();
		return getUserProfile().getProperties().getNickname();
	}
	
	@Override
	public KakaoProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v2/user/me"), KakaoProfile.class);
	}
	
	@Override
	public KakaoProfile unlink() {
		requireAuthorization();
		
		return restTemplate.postForObject(buildApiUri("/v1/user/unlink"), null, KakaoProfile.class);
	}
	
	@Override
	public AccessTokenInfo accessTokenInfo() {
		requireAuthorization();
		
		return restTemplate.getForObject(buildApiUri("/v1/user/access_token_info"), AccessTokenInfo.class);
	}
	
	@Override
	public KakaoProfile updateProfile(String profileJsonString) {
		requireAuthorization();
		
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
		param.set("properties", profileJsonString);
		
		return restTemplate.postForObject(buildApiUri("/v1/user/update_profile"), param, KakaoProfile.class);
	}
	
	@Override
	public KakaoProfile logout() {
		requireAuthorization();
		
		return restTemplate.postForObject(buildApiUri("/v1/user/logout"), null, KakaoProfile.class);
	}
	
	@Override
	public KakaoProfile signup(String profileJsonString) {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		if (!StringUtils.isEmpty(profileJsonString)) {
			param.set("properties", profileJsonString);
		}
		
		return restTemplate.postForObject(buildApiUri("/v1/user/signup"), param, KakaoProfile.class);
	}
	
	@Override
	public KakaoIds ids() {
		return ids("", "", ""); //default search call
	}
	
	@Override
	public KakaoIds ids(String limit, String fromId, String order) {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("limit", limit);
		param.set("fromId", fromId);
		param.set("order", order);
		
		return adminRestTemplate.getForObject(buildApiUri("/v1/user/ids", param), KakaoIds.class);
	}
	
	@Override
	public KakaoProfile getUserProfile(String userId) {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("user_id", userId);
		
		return adminRestTemplate.getForObject(buildApiUri("/v2/user/me", param), KakaoProfile.class);
	}
	
}
