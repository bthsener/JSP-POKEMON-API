package POJO;

import jakarta.persistence.Embeddable;

@Embeddable
public class Stats {

	private int base_stat;
	private int effort;
	private StatsInfo stat;
	
	public int getBase_stat() {
		return base_stat;
	}
	public void setBase_stat(int base_stat) {
		this.base_stat = base_stat;
	}
	public int getEffort() {
		return effort;
	}
	public void setEffort(int effort) {
		this.effort = effort;
	}
	public StatsInfo getStat() {
		return stat;
	}
	public void setStat(StatsInfo stat) {
		this.stat = stat;
	}
	
}
