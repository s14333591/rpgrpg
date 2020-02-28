package jp.co.rpg.entity;

import java.util.ArrayList;
import java.util.List;

public class BattleInfo {

	private static final String CONTINUE = "continue";
	private static final String WIN = "win";
	private static final String LOSE = "lose";
	private String status = CONTINUE;
	private String lvUpContext;

	private List<String> context = new ArrayList<String>();

	private Integer userHp;
	private Integer userMp;

	private boolean isMagic = false;
	private boolean isLvUp = false;

	private Magic magic;
	private Lv nextLv;

	public List<String> getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context.add(context);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		switch(status) {
		case "win":
			this.status = WIN;
			break;
		case "lose":
			this.status = LOSE;
			break;
		default:
			this.status = CONTINUE;
			break;
		}
	}

	public Integer getUserHp() {
		return userHp;
	}

	public void setUserHp(Integer userHp) {
		this.userHp = userHp;
	}

	public Integer getUserMp() {
		return userMp;
	}

	public void setUserMp(Integer userMp) {
		this.userMp = userMp;
	}

	public boolean getIsMagic() {
		return isMagic;
	}

	public void setIsMagic(boolean bool) {
		this.isMagic = bool;
	}

	public void setMagic(Magic magic) {
		this.magic = magic;
	}

	public Magic getMagic() {
		return magic;
	}

	public void setNextLv(Lv nextLv) {
		this.nextLv = nextLv;
	}

	public Lv getNextLv() {
		return nextLv;
	}

	public boolean getIsLvUp() {
		return isLvUp;
	}

	public void setIsLvUp(boolean bool) {
		this.isLvUp = bool;
	}

	public void setLvUpContext(String lvUpContext) {
		this.lvUpContext = lvUpContext;
	}

	public String getLvUpContext() {
		return lvUpContext;
	}

}