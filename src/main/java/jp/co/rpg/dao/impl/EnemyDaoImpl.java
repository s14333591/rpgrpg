package jp.co.rpg.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rpg.dao.EnemyDao;
import jp.co.rpg.entity.Enemy;
import jp.co.rpg.entity.User;

@Repository
public class EnemyDaoImpl implements EnemyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;



	@Override
	public List<Enemy> findAppear(User user) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sqlFindApper = "SELECT * FROM enemies WHERE appear_lv <= :lv ORDER BY id";
		param.addValue("lv", user.getLv());

		return	jdbcTemplate.query(
				sqlFindApper,
				param,
				new BeanPropertyRowMapper<Enemy>(Enemy.class));
	}

	@Override
	public List<Enemy> findBoss() {
		 return jdbcTemplate.query("SELECT * FROM enemies WHERE id = 999", new BeanPropertyRowMapper<Enemy>(Enemy.class));
	}
}
