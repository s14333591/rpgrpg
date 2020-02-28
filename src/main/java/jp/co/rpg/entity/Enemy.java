package jp.co.rpg.entity;

public class Enemy extends Chara {


	private Integer appearLv;
	private Integer dropXp;
	private Integer dropGold;

//	getter setter
	public Integer getAppearLv() {
		return appearLv;
	}
	public void setAppearLv(Integer appearLv) {
		this.appearLv = appearLv;
	}
	public Integer getDropXp() {
		return dropXp;
	}
	public void setDropXp(Integer dropXp) {
		this.dropXp = dropXp;
	}
	public Integer getDropGold() {
		return dropGold;
	}
	public void setDropGold(Integer dropGold) {
		this.dropGold = dropGold;
	}

	//User敗北
	//CharaインターフェースのbattleCalcメソッドで使用
	@Override
	public void win(BattleInfo bi, Chara chara) {
		User user = (User)chara;
		user.setGold(user.getGold() / 2);
		user.setHp(1);
		bi.setUserHp(0);
		bi.setStatus("lose");
	}

	//まほうこうげき
	//敵はまほうが使えないので処理無し
	@Override
	public void spellMagic(BattleInfo bi, Chara chara) {

	}

}
