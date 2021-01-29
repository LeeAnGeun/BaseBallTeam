package dto;

public class PitcherDto extends HumanDto {
	String win;
	String lose;
	String defence;
	
	public PitcherDto() {
		
	}
	
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
	public String toString() {
		return "[position=" + pAndb + ", name=" + name + ", age=" + age + ", height=" + height + ", win=" + win + ", lose=" + lose + ", defence=" + defence + "]";
	}

	
}
