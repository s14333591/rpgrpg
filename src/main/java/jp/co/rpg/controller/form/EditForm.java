package jp.co.rpg.controller.form;

import javax.validation.constraints.NotBlank;

public class EditForm {
	@NotBlank(message = "※入力してください")
	private String userName;
	@NotBlank(message = "※入力してください")
	private String password;
	@NotBlank(message = "※入力してください")
	private String rePassword;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}


}
