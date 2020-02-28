package jp.co.rpg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	@Autowired
	HttpSession session;

	//ホーム→スタート
	@RequestMapping(value = "/index", method = RequestMethod.GET, params="logout")
	public String home() {
		session.invalidate();
		return "index";
	}


}
