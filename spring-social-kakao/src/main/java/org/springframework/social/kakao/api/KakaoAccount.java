package org.springframework.social.kakao.api;

import java.io.Serializable;

public class KakaoAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public KakaoAccount() {
		//
	}
	
	private Boolean email_needs_aggrement;
	private Boolean is_email_valid;
	private Boolean is_email_verified;
	private String email;
	private Boolean age_range_needs_agreement;
	private String age_range;
	private Boolean birthday_needs_agreement;
	private String birthday;
	private Boolean gender_needs_agreement;
	private String gender;
	
	public Boolean getEmail_needs_aggrement() {
		return email_needs_aggrement;
	}
	public void setEmail_needs_aggrement(Boolean email_needs_aggrement) {
		this.email_needs_aggrement = email_needs_aggrement;
	}
	
	public Boolean getIs_email_valid() {
		return is_email_valid;
	}
	public void setIs_email_valid(Boolean is_email_valid) {
		this.is_email_valid = is_email_valid;
	}
	
	public Boolean getIs_email_verified() {
		return is_email_verified;
	}
	public void setIs_email_verified(Boolean is_email_verified) {
		this.is_email_verified = is_email_verified;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getAge_range_needs_agreement() {
		return age_range_needs_agreement;
	}
	public void setAge_range_needs_agreement(Boolean age_range_needs_agreement) {
		this.age_range_needs_agreement = age_range_needs_agreement;
	}
	
	public String getAge_range() {
		return age_range;
	}
	public void setAge_range(String age_range) {
		this.age_range = age_range;
	}
	
	public Boolean getBirthday_needs_agreement() {
		return birthday_needs_agreement;
	}
	public void setBirthday_needs_agreement(Boolean birthday_needs_agreement) {
		this.birthday_needs_agreement = birthday_needs_agreement;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Boolean getGender_needs_agreement() {
		return gender_needs_agreement;
	}
	public void setGender_needs_agreement(Boolean gender_needs_agreement) {
		this.gender_needs_agreement = gender_needs_agreement;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
