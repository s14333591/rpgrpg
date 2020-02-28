package jp.co.rpg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.rpg.controller.form.EditForm;
import jp.co.rpg.entity.User;

@Controller
public class EditController {
	@Autowired
	HttpSession session;

	//ホーム→へんしゅう
	@RequestMapping("/edit")
	public String login(@ModelAttribute("edit") EditForm form, Model model) {
		return "edit";
	}

	//へんしゅう→ホーム
	@RequestMapping(value = "/home", method = RequestMethod.POST, params="edit")
	public String home(@Validated @ModelAttribute("edit") EditForm form, BindingResult bindingResult, Model model) {

		//入力チェック
		if (bindingResult.hasErrors())
			return "edit";

		if(!form.getPassword().equals(form.getRePassword())) {
			model.addAttribute("errMsgEdit", "あんごうとあんごう(かくにん)がいっちしません");
			return "edit";
		}

		User user = (User) session.getAttribute("user");

		user.setName(form.getUserName());
		user.setPassword(form.getPassword());
		session.setAttribute("user", user);

		return "home";

	}

	//へんしゅう→ホーム(もどる)
	@RequestMapping(value = "/home", method = RequestMethod.GET, params="edit")
	public String getHome() {

		return "home";
	}
}
