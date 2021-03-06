package dto;

public class Batter extends HumanDto {
	private String batCount;
	private String hit;
	private String hitAvg;
	

	public Batter(String pAndb, String name, String age, String height, String batCount, String hit, String hitAvg) {
		super(pAndb, name, age, height);
		this.batCount = batCount;
		this.hit = hit;
		this.hitAvg = hitAvg;
	}
	
	public String getBatCount() {
		return batCount;
	}

	public void setBatCount(String batCount) {
		this.batCount = batCount;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getHitAvg() {
		return hitAvg;
	}

	public void setHitAvg(String hitAvg) {
		this.hitAvg = hitAvg;
	}

	@Override
	public String alldata() {
		return getPosition() + "-" + getName() + "-" + getAge() + "-" + getHeight()
											+"-" + batCount + "-" + hit + "-" + hitAvg;
	}
	
	@Override
	public String toString() {
		return "[position=" + position + ", name=" + name + ", age=" + age + ", height=" + height +", batCount=" + batCount + ", hit=" + hit + ", hitAvg=" + hitAvg + "]";
	}
	
	
}
