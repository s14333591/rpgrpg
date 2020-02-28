package jp.co.rpg.dao;

import java.util.List;

import jp.co.rpg.entity.Magic;

public interface MagicDao {

	List<Magic> findWizard();

	List<Magic> findAll();

}
