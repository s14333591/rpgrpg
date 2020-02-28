package jp.co.rpg.dao;

import java.util.List;

import jp.co.rpg.entity.Enemy;
import jp.co.rpg.entity.User;


public interface EnemyDao {

	List<Enemy> findAppear(User user);

	List<Enemy> findBoss();

}
