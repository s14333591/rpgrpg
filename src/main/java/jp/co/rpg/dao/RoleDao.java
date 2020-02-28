package jp.co.rpg.dao;

import java.util.List;

import jp.co.rpg.entity.Role;

public interface RoleDao {

	public List<Role> getAll();

	List<Role> find(Role role);

}
