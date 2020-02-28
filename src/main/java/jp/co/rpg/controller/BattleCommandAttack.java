package jp.co.rpg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.rpg.entity.BattleInfo;
import jp.co.rpg.entity.Enemy;
import jp.co.rpg.entity.Lv;
import jp.co.rpg.entity.Magic;
import jp.co.rpg.entity.User;

@RestController
@ResponseBody
public class BattleCommandAttack{
	@Autowired
	HttpSession session;

	//ごうげき
	@RequestMapping("/attack")
	public BattleInfo Attack(@RequestParam("magicId")Integer magicId) {

		//ユーザーと敵の情報取得
		User user = (User) session.getAttribute("user");
		Enemy enemy = (Enemy) session.getAttribute("enemy");
		Lv nextLv = (Lv) session.getAttribute("nextLv");
		BattleInfo bi = new BattleInfo();
		bi.setNextLv(nextLv);

		//まほうが選択された場合
		if(magicId != 0) {
			bi.setIsMagic(true);
			List <Magic> magicList = (List) session.getAttribute("magicList");
			Magic magic = magicList.get(magicId);
			bi.setMagic(magic);
		}

		//スピードチェック
		if(user.getSpeed() >= enemy.getSpeed()) {
			//ユーザー先攻
			if(user.battleCalc(bi, enemy)) {
				bi.setIsMagic(false);
				enemy.battleCalc(bi, user);
			}
		}else {
			//ユーザー後攻
			boolean temp = bi.getIsMagic();
			bi.setIsMagic(false);
			if(enemy.battleCalc(bi, user)) {
				bi.setIsMagic(temp);
				user.battleCalc(bi, enemy);
			}
		}
		if(!bi.getStatus().equals("lose"))
			bi.setUserHp(user.getHp());
		bi.setUserMp(user.getMp());
		session.setAttribute("user", user);
		return bi;
	}
}