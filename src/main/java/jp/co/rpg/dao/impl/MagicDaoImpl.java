package jp.co.rpg.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rpg.dao.MagicDao;
import jp.co.rpg.entity.Magic;

@Repository
public class MagicDaoImpl implements MagicDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Magic> findWizard() {
		 return jdbcTemplate.query("SELECT * FROM magics WHERE NOT (id = 3) ORDER BY id", new BeanPropertyRowMapper<Magic>(Magic.class));
	}

	@Override
	public List<Magic> findAll() {
		 return jdbcTemplate.query("SELECT * FROM magics ORDER BY id", new BeanPropertyRowMapper<Magic>(Magic.class));
	}
}
