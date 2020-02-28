package jp.co.rpg.entity;

public class Role {

	private Integer id;
	private String name;
	private Float powerRate;
	private Float intelligenceRate;
	private Float defenceRate;
	private Float speedRate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPowerRate() {
		return powerRate;
	}
	public void setPowerRate(Float powerRate) {
		this.powerRate = powerRate;
	}
	public Float getIntelligenceRate() {
		return intelligenceRate;
	}
	public void setIntelligenceRate(Float intelligenceRate) {
		this.intelligenceRate = intelligenceRate;
	}
	public Float getDefenceRate() {
		return defenceRate;
	}
	public void setDefenceRate(Float defenceRate) {
		this.defenceRate = defenceRate;
	}
	public Float getSpeedRate() {
		return speedRate;
	}
	public void setSpeedRate(Float speedRate) {
		this.speedRate = speedRate;
	}

}
