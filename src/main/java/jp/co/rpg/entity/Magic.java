package jp.co.rpg.entity;

public class Magic {
	private Integer id;
	private String name;
	private Integer type;
	private Integer needMp;
	private Integer acquireLv;
	private Float magicRate;

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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getNeedMp() {
		return needMp;
	}
	public void setNeedMp(Integer needMp) {
		this.needMp = needMp;
	}
	public Integer getAcquireLv() {
		return acquireLv;
	}
	public void setAcquireLv(Integer acquireLv) {
		this.acquireLv = acquireLv;
	}
	public Float getMagicRate() {
		return magicRate;
	}
	public void setMagicRate(Float magicRate) {
		this.magicRate = magicRate;
	}
}
