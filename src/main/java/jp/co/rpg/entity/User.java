package jp.co.rpg.entity;

public class User extends Chara{

	// フィールド
	private String userId;
	private String password;
	private Role role;
	private Integer lv;
	private Integer maxHp;
	private Integer maxMp;
	private Integer xp;
	private Integer gold;
	private Integer sinceDays;
	private String createDate;
	private String updateDate;
	private Integer adminFlg;
	private Integer clearFlg;
	private Integer deleteFlg;

//	コンストラクタ
	public User() {

	}
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

//	getter setter
	public void setRoleId(Integer roleId) {
		if(role == null)
			role = new Role();
		role.setId(roleId);
	}

	public void setRoleName(String roleName) {
		if(role == null)
			role = new Role();
		role.setName(roleName);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getLv() {
		return lv;
	}

	public void setLv(Integer lv) {
		this.lv = lv;
	}

	public void setHp(Integer hp) {
		if(hp < 0)
			hp = 0;
		if(this.getMaxHp() < hp)
			hp = this.getMaxHp();

		this.hp = hp;
	}

	public Integer getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(Integer maxHp) {
		this.maxHp = maxHp;
	}

	public Integer getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(Integer maxMp) {
		this.maxMp = maxMp;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		if(this.getLv() >= 10)
			xp = 0;
		this.xp = xp;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getSinceDays() {
		return sinceDays;
	}

	public void setSinceDays(Integer sinceDays) {
		this.sinceDays = sinceDays;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getAdminFlg() {
		return adminFlg;
	}

	public void setAdminFlg(Integer adminFlg) {
		this.adminFlg = adminFlg;
	}

	public Integer getClearFlg() {
		return clearFlg;
	}

	public void setClearFlg(Integer clearFlg) {
		this.clearFlg = clearFlg;
	}

	public Integer getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(Integer deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	//User勝利
	//CharaインターフェースのbattleCalcメソッドで使用
	@Override
	public void win(BattleInfo bi, Chara chara) {
		Enemy enemy = (Enemy)chara;
		bi.setStatus("win");
		if(this.getLv() < 10)
			this.setXp(this.getXp() + enemy.getDropXp());
		this.setGold(this.getGold() + enemy.getDropGold());

		if(this.getLv() >= 10)
			enemy.setDropXp(0);

		bi.setContext("<br><p>" + enemy.getName() + "をたおした。</p>"
				+ "<p>" + enemy.getDropXp() + "XPと"
				+ enemy.getDropGold() + "G をかくとくした</p>");

		//LVアップ判定
		if(bi.getNextLv().getNeedXp() <= xp && lv <10)
			lvUp(bi);
	}

	//まほうこうげき
	@Override
	public void spellMagic(BattleInfo bi, Chara chara) {
		Enemy enemy = (Enemy)chara;
		Magic magic = bi.getMagic();
		bi.setContext(this.getName() + "は" + magic.getName()+"をとなえた");

		switch(magic.getType()) {

		//こうげきまほう
		case 1:
			if(this.getMp() - magic.getNeedMp() < 0) {
				bi.setContext("MPがたりなかった");
				return;
			}
			Integer damage = (int) (this.getIntelligence() * magic.getMagicRate() - enemy.getDefense()) + (int) (Math.random() * 4) ;
			if(damage <= 0)
				damage = 1;
			bi.setContext(enemy.getName() + "に" + damage + "のダメージをあたえた");
			enemy.setHp(enemy.getHp() - damage);
			this.setMp(this.getMp() - magic.getNeedMp());
			break;
		//かいふくまほう
		case 2:
			if(this.getMp() - magic.getNeedMp() < 0) {
				bi.setContext("MPがたりなかった");
				return;
			}

			Integer healHp = (int) (this.getIntelligence() * magic.getMagicRate());
			//回復量が最大HPを超過していた場合
			if(healHp + this.getHp() > this.getMaxHp()) {
				healHp = this.getMaxHp() - this.getHp();
				this.setHp(this.getMaxHp());
			}else {
				this.setHp(this.getHp() + healHp);
			}
			bi.setContext("HPが" + healHp + "かいふくした");
			this.setMp(this.getMp() - magic.getNeedMp());
			break;
		}
		bi.setUserHp(this.getHp());
		bi.setUserMp(this.getMp());
	}

	//LVアップ
	private void lvUp(BattleInfo bi) {
		//レベルアップ乱数調整
		final Integer MAX_HP_UP_RATE = 2;
		final Integer MAX_MP_UP_RATE = 2;
		final Integer POWER_UP_RATE = 1;
		final Integer INTELLIGENCE_UP_RATE = 1;
		final Integer DEFENSE_UP_RATE = 1;
		final Integer SPEED_UP_RATE = 1;

		Integer maxHpUp = (int) (Math.random() * 3 + 4) * MAX_HP_UP_RATE;
		Integer maxMpUp = (int) (Math.random() * 3 + 4) * MAX_MP_UP_RATE;
		Integer powerUp = (int) (Math.random() * 4 + 3) * POWER_UP_RATE;
		Integer intelligenceUp = (int) (Math.random() * 4 + 3) * INTELLIGENCE_UP_RATE;
		Integer defenseUp = (int) (Math.random() * 4 + 3) * DEFENSE_UP_RATE;
		Integer speedUp = (int) (Math.random() * 4 + 3) * SPEED_UP_RATE;

		this.setLv(bi.getNextLv().getLv());
		this.setXp(bi.getNextLv().getNeedXp());
		this.setMaxHp(this.getMaxHp() + maxHpUp);
		this.setMaxMp(this.getMaxMp() + maxMpUp);
		this.setPower(this.getPower() + powerUp);
		this.setIntelligence(this.getIntelligence() + intelligenceUp);
		this.setDefense(this.getDefense() + defenseUp);
		this.setSpeed(this.getSpeed() + speedUp);

		//メッセージの格納
		bi.setLvUpContext(
				"<p>" + this.getName() + "はレベルがあがった！</p>" +
				"<p>さいだいHPが" + maxHpUp + "</p>" +
				"<p>さいだいMPが" + maxMpUp + "</p>" +
				"<p>ちからが" + powerUp + "</p>" +
				"<p>かしこさが" + intelligenceUp + "</p>" +
				"<p>ぼうぎょが" + defenseUp + "。</p>" +
				"<p>すばやさが" + speedUp + "あがった</p>"
		);
		bi.setIsLvUp(true);
	}

}
