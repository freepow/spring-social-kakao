package org.springframework.social.kakao.api;

import java.io.Serializable;

public class KakaoProfile extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	KakaoProfile() {
		// do nothing
	}
	
	private long id;
	private KakaoAccount kakao_account;
	private KakaoProfileProperties properties;
	
	public long getId() {
		return this.id;
	}
	
	public KakaoAccount getKakao_account() {
		return this.kakao_account;
	}
	
	public KakaoProfileProperties getProperties() {
		return this.properties;
	}
	
}
