package jp.co.rpg.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rpg.dao.RoleDao;
import jp.co.rpg.entity.Role;
import jp.co.rpg.util.Util;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Role> getAll() {
		 return jdbcTemplate.query("SELECT * FROM roles ORDER BY id", new BeanPropertyRowMapper<Role>(Role.class));
	}

	@Override
	public List<Role> find (Role role) {
		String SQL_SELECT_FIND = "";
		StringBuilder forSearch = new StringBuilder("SELECT * FROM roles where 1 = 1");
		MapSqlParameterSource param = new MapSqlParameterSource();

		if(!(Util.isNullOrEmpty(role.getId()))) {
			forSearch.append(" AND id = :id");
			param.addValue("id", role.getId());
		}
		if(!(Util.isNullOrEmpty(role.getName()))) {
			forSearch.append(" AND name = :name");
			param.addValue("password", role.getName());
		}

		SQL_SELECT_FIND = forSearch.toString();

		return jdbcTemplate.query(SQL_SELECT_FIND, param, new BeanPropertyRowMapper<Role>(Role.class));
	}

}
