package jp.co.rpg.dao;

import java.util.List;

import jp.co.rpg.entity.Lv;

public interface LvDao {

	public List<Lv> getAll();

	Lv lvCheck(Integer xp);

	public List<Lv> findNextLv(Integer nowLv);
}


