package jp.co.rpg.dao;

import java.util.List;

import jp.co.rpg.entity.User;

//制作日：2020.02.14
//制作者：新垣
public interface UserDao {

	public void createAccount(User user);
	public List<User> find(User user);
	public void update(User user);
	public void clearUpdate(User user);
}
