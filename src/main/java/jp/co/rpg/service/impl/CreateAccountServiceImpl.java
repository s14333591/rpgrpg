package jp.co.rpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rpg.dao.RoleDao;
import jp.co.rpg.dao.UserDao;
import jp.co.rpg.entity.Role;
import jp.co.rpg.entity.User;
import jp.co.rpg.service.CreateAccountService;

@Service
public class CreateAccountServiceImpl implements CreateAccountService {

	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;

	@Override
	public boolean idCheck(String userId) {
		User user = new User();
		user.setUserId(userId);
		if((userDao.find(user)).size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User createAccount(User user, Role role) {

//		entityUserに初期値フィールドをセット
		user.setLv(lv);
		user.setMaxHp(maxHp);
		user.setHp(hp);
		user.setMaxMp(maxMp);
		user.setMp(mp);
		user.setPower((int)(power * role.getPowerRate()));
		user.setIntelligence((int)(intelligence * role.getIntelligenceRate()));
		user.setDefense((int)(defense * role.getDefenceRate()));
		user.setSpeed((int)(speed * role.getSpeedRate()));
		user.setXp(xp);
		user.setGold(gold);
		user.setSinceDays(sinceDays);
		user.setAdminFlg(adminFlg);
		user.setClearFlg(clearFlg);
		user.setDeleteFlg(deleteFlg);
		userDao.createAccount(user);

		return user;

	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

	@Override
	public String isRoleName(User user) {

		List<Role> list = new ArrayList<Role>();
		list = roleDao.find(user.getRole());

		return (list.get(0)).getName();
	}

}
