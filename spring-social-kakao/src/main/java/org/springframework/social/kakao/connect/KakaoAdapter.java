package org.springframework.social.kakao.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.KakaoProfile;
import org.springframework.social.kakao.api.KakaoProfileProperties;

public class KakaoAdapter implements ApiAdapter<Kakao> {
	
	@Deprecated
	@Override
	public boolean test(Kakao api) {
		// do nothing
		return false;
	}
	
	@Override
	public void setConnectionValues(Kakao kakao, ConnectionValues values) {
		KakaoProfile profile = kakao.userOperation().getUserProfile();
		KakaoProfileProperties properties = profile.getProperties();
		if (properties == null) {
			properties = new KakaoProfileProperties();
		}
		
		String nickName = properties.getNickname();
		// 닉네임에 emoji 제거
		String displayName = this.removeEmoji(nickName);
		
		values.setProviderUserId(Long.toString(profile.getId()));
		values.setDisplayName(displayName);
		values.setProfileUrl("");
		values.setImageUrl(profile.getProperties().getProfile_image());
	}
	
	@Override
	public UserProfile fetchUserProfile(Kakao kakao) {
		KakaoProfile profile = kakao.userOperation().getUserProfile();
		
		String nickName = profile.getProperties().getNickname();
		// 닉네임에 emoji 제거
		String username = this.removeEmoji(nickName);
		
		return new UserProfileBuilder()
				.setName(username)
				.setUsername(username)
				.setEmail(profile.getKakao_account().getEmail())
				.build();
	}
	
	@Deprecated
	@Override
	public void updateStatus(Kakao kakao, String message) {
		// do nothing
	}
	
	/**
	 * 이모지(emoji) 문자 제거
	 *
	 * @param text
	 * @return
	 */
	private String removeEmoji(String text) {
		String regex = "[^\\p{L}\\p{N}\\p{P}\\p{Z}]";
		String result = text.replaceAll(regex, "");
		
		return result;
	}
	
}
