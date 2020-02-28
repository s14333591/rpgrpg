package jp.co.rpg.controller.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {

	@NotBlank(message = "※入力してください")
	private String userId;
	@NotBlank(message = "※入力してください")
	private String password;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
