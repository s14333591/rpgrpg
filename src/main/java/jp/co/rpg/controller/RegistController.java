package jp.co.rpg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.rpg.controller.form.RegistForm;
import jp.co.rpg.dao.LvDao;
import jp.co.rpg.dao.RoleDao;
import jp.co.rpg.entity.Role;
import jp.co.rpg.entity.User;
import jp.co.rpg.service.CreateAccountService;

//制作日：2020.02.14
//制作者：新垣
@Controller
public class RegistController {

	@Autowired
	CreateAccountService service;
	@Autowired
	HttpSession session;
	@Autowired
	private LvDao lvDao;
	@Autowired
	private RoleDao roleDao;

//	idex.jsp
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

//	idex.jsp - regist.jsp
	@RequestMapping("/regist")
	public String createAccountPage(@ModelAttribute("regist") RegistForm form, Model model) {
		return "regist";
	}

//	regist.jsp - confirm.jsp
	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public String confirm(@Validated @ModelAttribute("regist") RegistForm form,
	BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "regist";
		}

//		IDの重複check
		if(service.idCheck(form.getUserId())) {
			model.addAttribute("msg", "そのIDはつかわれています");
			return "regist";
		}

//		passwordの確認
		if(!((form.getPassword()).equals(form.getPasswordCheck()))) {
			model.addAttribute("msg", "あんごうとあんごう(かくにん)がいっちしません");
			return "regist";
		}

//		セッションにUer型の情報を保存
		User user = new User();

		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setName(form.getName());
		user.setRoleId(form.getRoleId());

		//ロールを全件取得して保存
		List<Role> roleList = roleDao.getAll();
		session.setAttribute("roleList", roleList);

		//ユーザーのroleIdのものを保存
		Role role = roleList.get(form.getRoleId()-1);
		session.setAttribute("role", role);

		session.setAttribute("user", user);
		return "registConfirm";
	}

//	confirm.jsp - home.jsp
	@RequestMapping(value = "/home", method = RequestMethod.POST, params="regist")
	public String home() {

//		CreateAccountServiceを使って登録
		User user = (User)session.getAttribute("user");
		Role role = (Role)session.getAttribute("role");
		user = service.createAccount(user, role);

		session.setAttribute("user", user);
		session.setAttribute("nextLv", lvDao.findNextLv(user.getLv()).get(0));

		return "home";
	}

}
