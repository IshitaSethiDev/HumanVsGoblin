package models;

public class Goblin {
	//Default Goblin Position
	private int rowPosition;
	private int columnPosition;
	private int strength;

	public Goblin() {
	}

	public Goblin(int rowPosition, int columnPosition, int strength) {
		super();
		this.rowPosition = rowPosition;
		this.columnPosition = columnPosition;
		this.strength = strength;
	}

	public int getRowPosition() {
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}

	public int getColumnPosition() {
		return columnPosition;
	}

	public void setColumnPosition(int columnPosition) {
		this.columnPosition = columnPosition;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

}
