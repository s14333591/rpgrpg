package jp.co.rpg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rpg.dao.UserDao;
import jp.co.rpg.entity.User;

@Controller
public class ClearController {

	@Autowired
	HttpSession session;
	@Autowired
	private UserDao userDao;

	@RequestMapping("/clear")
	public String clear() {

		User user = (User) session.getAttribute("user");
		userDao.clearUpdate(user);

		return "clear";
	}

}
