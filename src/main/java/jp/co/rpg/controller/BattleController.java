package jp.co.rpg.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rpg.dao.EnemyDao;
import jp.co.rpg.dao.LvDao;
import jp.co.rpg.dao.MagicDao;
import jp.co.rpg.entity.Enemy;
import jp.co.rpg.entity.Lv;
import jp.co.rpg.entity.Magic;
import jp.co.rpg.entity.Role;
import jp.co.rpg.entity.User;

@Controller
public class BattleController {
	@Autowired
	HttpSession session;
	@Autowired
	private EnemyDao enemyDao;
	@Autowired
	private MagicDao magicDao;
	@Autowired
	private LvDao lvDao;

	//ホーム→せんとう(通常)
	@RequestMapping("/battle")
	public String Battle(@RequestParam("name")String enemyType) {

		//ユーザー情報取得
		User user = (User) session.getAttribute("user");
		Role role = (Role) session.getAttribute("role");
		Enemy enemy = new Enemy();

		if("usual".equals(enemyType)) {
			//出現LVがユーザーLV以下の敵データを取得
			List<Enemy> enemyList = enemyDao.findAppear(user);

			if(user.getLv() > 2) {
				//LV3以上の時はスライム出現無し
				enemyList.remove(0);

				if(user.getLv() > 4) {
					//LV5以上の時はキメラ出現無し
					enemyList.remove(0);
				}
			}

			//乱数を用いてリストから出現する敵を選択
			Random random = new Random();
			enemy = enemyList.get(random.nextInt(enemyList.size()));
		}else {
			//ボスデータを取得
			enemy = enemyDao.findBoss().get(0);
		}

		session.setAttribute("enemy", enemy);


		//習得済み魔法取得（DAOやテーブルを含めて大幅に改善の必要あり）
		if(role.getId() != 1) {
			List<Magic> magicList = null;
			if(role.getId() == 2) {
				magicList = magicDao.findWizard();
			}else if(role.getId() == 3) {
				magicList = magicDao.findAll();
			}
			//jsで操作しやすいよう、リストをずらす
			magicList.add(0, null);
			session.setAttribute("magicList", magicList);
		}

		return "battle";
	}

	//せんとう(通常)→ホーム
	@RequestMapping("/home")
	public String home() {

		//ユーザー情報取得
		User user = (User) session.getAttribute("user");

		//ユーザの次のLVのインスタンスを保存
		Lv nextLv = new Lv();
		if(user.getLv() < 10) {
			nextLv = lvDao.findNextLv(user.getLv()).get(0);
		}else {
			nextLv.setNeedXp(user.getXp());
		}
		session.setAttribute("nextLv", nextLv);

		return "home";
	}
}
