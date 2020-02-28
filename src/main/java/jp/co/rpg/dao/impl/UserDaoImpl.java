package jp.co.rpg.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rpg.dao.UserDao;
import jp.co.rpg.entity.User;
import jp.co.rpg.util.Util;

//制作日：2020.02.14
//制作者：新垣
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String SQL_CREATE_ACCOUNT = "INSERT INTO users VALUES ("
			+ "(SELECT CASE WHEN (MAX(id) + 1) IS null THEN 1 ELSE MAX(id) + 1 END FROM users),"
			+ ":user_id, :password, :name, :role_id, "
			+ ":lv, :max_hp, :hp, :max_mp, :mp, :power, :intelligence, :defense, :speed, "
			+ ":xp, :gold, :since_days, "
			+ "current_date, current_date, "
			+ ":admin_flg, :clear_flg, :delete_flg)";

	private static final String SQL_UPDATE = "UPDATE users SET "
			+ "password = :password, name = :name, role_id = :role_id, "
			+ "lv = :lv, max_hp = :max_hp, hp = :hp, max_mp = :max_mp, mp = :mp,"
			+ "power = :power, intelligence = :intelligence, defense = :defense, speed = :speed, "
			+ "xp = :xp, gold = :gold, "
			+ "since_days = :since_days, update_date = current_date "
			+ "WHERE user_id = :user_id";

	private static final String SQL_CLEARUPDATE = "UPDATE users SET "
			+ "password = :password, name = :name, role_id = :role_id, "
			+ "lv = :lv, max_hp = :max_hp, hp = :hp, max_mp = :max_mp, mp = :mp,"
			+ "power = :power, intelligence = :intelligence, defense = :defense, speed = :speed, "
			+ "xp = :xp, gold = :gold, "
			+ "since_days = :since_days, update_date = current_date, "
			+ "clear_flg = 1 "
			+ "WHERE user_id = :user_id";

	@Override
	public void createAccount(User user) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user.getUserId());
		param.addValue("password", Util.hash(user.getPassword()));
		param.addValue("name", user.getName());
		param.addValue("role_id", user.getRole().getId());
		param.addValue("lv", user.getLv());
		param.addValue("max_hp", user.getMaxHp());
		param.addValue("hp", user.getHp());
		param.addValue("max_mp", user.getMaxMp());
		param.addValue("mp", user.getMp());
		param.addValue("power", user.getPower());
		param.addValue("intelligence", user.getIntelligence());
		param.addValue("defense", user.getDefense());
		param.addValue("speed", user.getSpeed());
		param.addValue("xp", user.getXp());
		param.addValue("gold", user.getGold());
		param.addValue("since_days", user.getSinceDays());
		param.addValue("admin_flg", user.getAdminFlg());
		param.addValue("clear_flg", user.getClearFlg());
		param.addValue("delete_flg", user.getDeleteFlg());

		jdbcTemplate.update(SQL_CREATE_ACCOUNT, param);

	}

	@Override
	public List<User> find(User user) {
		String SQL_SELECT_FIND = "";
		StringBuilder forSearch = new StringBuilder("SELECT * FROM users where 1 = 1");
		MapSqlParameterSource param = new MapSqlParameterSource();

		if(!(Util.isNullOrEmpty(user.getUserId()))) {
			forSearch.append(" AND user_id = :userId");
			param.addValue("userId", user.getUserId());
		}
		if(!(Util.isNullOrEmpty(user.getPassword()))) {
			forSearch.append(" AND password = :password");
			param.addValue("password", Util.hash(user.getPassword()));
		}

		SQL_SELECT_FIND = forSearch.toString();


		return	jdbcTemplate.query(
				SQL_SELECT_FIND,
				param,
				new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public void update(User user) {
		 MapSqlParameterSource param = usualUpdate(user);
		jdbcTemplate.update(SQL_UPDATE, param);

	}

	@Override
	public void clearUpdate(User user) {
		MapSqlParameterSource param = usualUpdate(user);
		jdbcTemplate.update(SQL_CLEARUPDATE, param);
	}

	//アップデートメソッド
	private MapSqlParameterSource usualUpdate(User user) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("password", Util.hash(user.getPassword()));
		param.addValue("name", user.getName());
		param.addValue("role_id", user.getRole().getId());
		param.addValue("lv", user.getLv());
		param.addValue("max_hp", user.getMaxHp());
		param.addValue("hp", user.getHp());
		param.addValue("max_mp", user.getMaxMp());
		param.addValue("mp", user.getMp());
		param.addValue("power", user.getPower());
		param.addValue("intelligence", user.getIntelligence());
		param.addValue("defense", user.getDefense());
		param.addValue("speed", user.getSpeed());
		param.addValue("xp", user.getXp());
		param.addValue("gold", user.getGold());
		param.addValue("since_days", user.getSinceDays());
		param.addValue("user_id", user.getUserId());
		return param;
	}

}
