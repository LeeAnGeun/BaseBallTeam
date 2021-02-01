package dto;

public class PitcherDto extends HumanDto {
	private String win;
	private String lose;
	private String defence;
	

	public PitcherDto(String pAndb, String name, String age, String height, String win, String lose, String defence) {
		super(pAndb, name, age, height);
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}
	
	
	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public String getLose() {
		return lose;
	}

	public void setLose(String lose) {
		this.lose = lose;
	}

	public String getDefence() {
		return defence;
	}

	public void setDefence(String defence) {
		this.defence = defence;
	}
	
	@Override
	public String alldata() {
		return getPosition() + "-" + getName() + "-" + getAge() + "-" + getHeight()
											+"-" + win + "-" + lose + "-" + defence;
	}
	@Override
	public String toString() {
		return "[position=" + position + ", name=" + name + ", age=" + age + ", height=" + height + ", win=" + win + ", lose=" + lose + ", defence=" + defence + "]";
	}

	
}
